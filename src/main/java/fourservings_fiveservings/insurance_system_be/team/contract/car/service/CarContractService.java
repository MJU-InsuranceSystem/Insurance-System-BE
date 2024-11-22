package fourservings_fiveservings.insurance_system_be.team.contract.car.service;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.exception.BusinessException;
import fourservings_fiveservings.insurance_system_be.common.exception.ResourceNotFoundException;
import fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType;
import fourservings_fiveservings.insurance_system_be.team.contract.car.controller.dto.request.CreateCarContractRequestDto;
import fourservings_fiveservings.insurance_system_be.team.contract.car.entity.CarContract;
import fourservings_fiveservings.insurance_system_be.team.contract.car.repository.CarContractRepository;
import fourservings_fiveservings.insurance_system_be.team.contract.common.controller.dto.response.CarContractDetailResponseDto;
import fourservings_fiveservings.insurance_system_be.team.insurance.entity.Insurance;
import fourservings_fiveservings.insurance_system_be.team.insurance.service.implement.InsuranceFinder;
import fourservings_fiveservings.insurance_system_be.user.entity.Customer;
import fourservings_fiveservings.insurance_system_be.user.entity.enums.UserType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CarContractService {

    private final InsuranceFinder insuranceFinder;
    private final CarContractRepository carContractRepository;

    public void createContract(Customer appliedCustomer,
        Long insuranceId, CreateCarContractRequestDto createCarContractRequestDto) {
        Insurance insurance = insuranceFinder.findById(insuranceId);
        CarContract carContract = createCarContractRequestDto.createPendingContract(appliedCustomer,
            insurance);
        carContractRepository.save(carContract);
    }

    public CarContractDetailResponseDto getContractDetail(Long contractId,
        CustomUserDetails customUserDetails) {

        if (customUserDetails.getRole().equals(UserType.CUSTOMER)) {
            CarContract carContract = carContractRepository.findByIdAndSubscriber(contractId,
                    customUserDetails.getCustom())
                .orElseThrow(() -> new ResourceNotFoundException(ErrorType.RESOURCE_NOT_FOUND));
            return CarContractDetailResponseDto.from(carContract);
        }
        if (customUserDetails.getRole().equals(UserType.WORKER)) {
            CarContract carContract = carContractRepository.findById(contractId)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorType.RESOURCE_NOT_FOUND));
            return CarContractDetailResponseDto.from(carContract);
        }
        throw new BusinessException(ErrorType.NO_EXIST_PERMISSION);
    }
}
