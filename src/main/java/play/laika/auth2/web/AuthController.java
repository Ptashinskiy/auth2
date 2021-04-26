package play.laika.auth2.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import play.laika.auth2.config.JwtProvider;
import play.laika.auth2.domain.security.User;
import play.laika.auth2.service.security.UserService;
import play.laika.auth2.web.io.AccessToken;
import play.laika.auth2.web.io.LoginRequest;
import play.laika.auth2.web.io.RegisterNewUserRequest;
import play.laika.auth2.web.io.UserDto;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtProvider jwtProvider;

    @Autowired
    public AuthController(UserService userService, JwtProvider jwtProvider) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping
    public ResponseEntity<UserDto> registerNewUser(@RequestBody RegisterNewUserRequest request) {
        UserDto newUser = userService.createNewUser(request.getDeviceId());
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<AccessToken> login(@RequestBody LoginRequest request) {
        User user = userService.findByDeviceId(request.getDeviceId());
        String accessToken = jwtProvider.generateToken(user.getDeviceId());
        return ResponseEntity.ok(new AccessToken(accessToken));
    }
}
