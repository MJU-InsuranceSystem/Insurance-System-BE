package fourservings_fiveservings.insurance_system_be.team.underwrite.control;

import fourservings_fiveservings.insurance_system_be.team.underwrite.api.UnderwriteApi;
import fourservings_fiveservings.insurance_system_be.team.underwrite.service.UnderWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UnderWriteControl implements UnderwriteApi {

    private final UnderWriteService underWriteService;
    
}
