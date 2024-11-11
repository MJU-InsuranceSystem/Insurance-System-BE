package fourservings_fiveservings.insurance_system_be.team.reward.accident.controller;

import fourservings_fiveservings.insurance_system_be.team.reward.accident.service.AccidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accident/customer")
@RequiredArgsConstructor
public class AccidentCustomerController {

    private final AccidentService accidentService;

}
