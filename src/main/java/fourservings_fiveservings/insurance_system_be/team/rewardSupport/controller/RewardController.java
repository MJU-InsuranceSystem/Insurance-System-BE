package fourservings_fiveservings.insurance_system_be.team.rewardSupport.controller;

import fourservings_fiveservings.insurance_system_be.team.rewardSupport.service.RewardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RewardController {

    private final RewardService rewardService;


}
