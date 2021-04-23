package play.laika.auth2.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/admin")
    public ResponseEntity<String> getAdmin() {
        return ResponseEntity.ok("Hello admin!");
    }

    @GetMapping("/user")
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok("Hello user!");
    }
}
