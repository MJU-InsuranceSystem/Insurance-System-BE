package fourservings_fiveservings.insurance_system_be;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/test")
public class ErrorTestController {

    @PostMapping("/error")
    public ResponseEntity<String> testServerError() {
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "강제 500에러 테스트");
    }
}

