package fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.service;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.file.service.S3Service;
import fourservings_fiveservings.insurance_system_be.team.contract.entity.common.Contract;
import fourservings_fiveservings.insurance_system_be.team.contract.service.implement.ContractFinder;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.controller.dto.request.RegisterAccidentRequestDto;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.entity.Accident;
import fourservings_fiveservings.insurance_system_be.team.rewardSupport.accident.repository.AccidentRepository;
import fourservings_fiveservings.insurance_system_be.user.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AccidentService {

    private final S3Service s3Service;
    private final ContractFinder contractFinder;
    private final AccidentRepository accidentRepository;

    @Transactional
    public void createAccident(CustomUserDetails customUserDetails, Long contractId, RegisterAccidentRequestDto registerAccidentRequestDto) {
        Customer customer = customUserDetails.getCustom();
        Contract contract = contractFinder.findById(contractId);
        String uploadFileName = s3Service.uploadFile(registerAccidentRequestDto.file());

        Accident accident = registerAccidentRequestDto.toAccident(customer, contract, uploadFileName);
        accidentRepository.save(accident);
    }
}
