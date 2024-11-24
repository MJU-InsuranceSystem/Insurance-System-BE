package fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.service;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.exception.BusinessException;
import fourservings_fiveservings.insurance_system_be.file.service.S3Service;
import fourservings_fiveservings.insurance_system_be.team.contract.common.entity.common.Contract;
import fourservings_fiveservings.insurance_system_be.team.contract.common.service.implement.ContractFinder;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.controller.dto.request.RegisterAccidentRequestDto;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.controller.dto.request.ReviewAccidentRequestDto;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.controller.dto.response.AccidentListResponseDto;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.controller.dto.response.AccidentResponseDto;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.entity.Accident;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.entity.LiabilityStatus;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.repository.AccidentRepository;
import fourservings_fiveservings.insurance_system_be.user.entity.Customer;
import fourservings_fiveservings.insurance_system_be.user.entity.User;
import fourservings_fiveservings.insurance_system_be.user.entity.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType.NO_EXIST_ACCIDENT;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AccidentService {

    private final S3Service s3Service;
    private final ContractFinder contractFinder;
    private final AccidentRepository accidentRepository;

    @Transactional
    public void createAccident(CustomUserDetails customUserDetails, Long contractId,
                               RegisterAccidentRequestDto registerAccidentRequestDto) {
        Customer customer = customUserDetails.getCustom();
        Contract contract = contractFinder.findById(contractId);
        String uploadFileName = s3Service.uploadFile(registerAccidentRequestDto.file());

        Accident accident = registerAccidentRequestDto.toAccident(customer, contract,
                uploadFileName);
        accidentRepository.save(accident);
    }

    public List<AccidentListResponseDto> getAllAccidents(CustomUserDetails customUserDetails) {
        User user = customUserDetails.getUser();
        if (user instanceof Customer customer) {
            List<Accident> accidentsByCustomer = accidentRepository.findAllByCustomerId(customer.getId());
            if (accidentsByCustomer == null || accidentsByCustomer.isEmpty()) {
                throw new BusinessException(NO_EXIST_ACCIDENT); // 예외 처리
            }
            return accidentsByCustomer.stream()
                    .map(AccidentListResponseDto::from)
                    .toList();
        }

        List<Accident> accidents = accidentRepository.findAll();
        if (accidents == null || accidents.isEmpty()) {
            throw new BusinessException(NO_EXIST_ACCIDENT); // 예외 처리
        }
        return accidents.stream()
                .map(AccidentListResponseDto::from)
                .toList();
    }

    public AccidentResponseDto getAccident(Long accidentId) {
        Accident accident = accidentRepository.findById(accidentId)
                .orElseThrow(() -> new BusinessException(NO_EXIST_ACCIDENT));
        String fileUrl = s3Service.getFileUrl(accident.getFileName());
        return AccidentResponseDto.from(accident, fileUrl);
    }

    @Transactional
    public void review(Worker worker, Long id, ReviewAccidentRequestDto request) {
        Accident accident = accidentRepository.findById(id)
                .orElseThrow(() -> new BusinessException(NO_EXIST_ACCIDENT));
        LiabilityStatus liabilityStatus = LiabilityStatus.findByDescription(request.liabilityStatus());
        accident.updateReview(worker, liabilityStatus, request.comments());
    }
}
