package fourservings_fiveservings.insurance_system_be;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class healthController {

    @GetMapping("/health")
    public ResponseEntity<?> serverCheck() {
        return ResponseEntity.ok().build();
    }
}
