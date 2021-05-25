package play.laika.auth2.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import play.laika.auth2.config.security.JwtFactory;
import play.laika.auth2.service.UserService;
import play.laika.auth2.web.io.AccessToken;
import play.laika.auth2.web.io.LoginRequest;
import play.laika.auth2.web.io.RegisterNewUserRequest;
import play.laika.auth2.web.io.UserDto;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtFactory jwtFactory;

    @Autowired
    public AuthController(UserService userService, JwtFactory jwtFactory) {
        this.userService = userService;
        this.jwtFactory = jwtFactory;
    }

    @PostMapping
    public ResponseEntity<UserDto> registerNewUser(@RequestBody RegisterNewUserRequest request) {
        UserDto newUser = userService.createNewUser(request.getDeviceId());
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/admins")
    public ResponseEntity<UserDto> registerNewAdmin(@RequestBody RegisterNewUserRequest request) {
        return ResponseEntity.ok(userService.createNewAdmin(request.getDeviceId()));
    }

    /** If an application requires password authentication - it must be implemented here:
     * request.getPassword().equals(user.getPassword())
     * */
    @PostMapping("/login")
    public ResponseEntity<AccessToken> login(@RequestBody LoginRequest request) {
        UserDto user = userService.findByDeviceId(request.getDeviceId());
        String accessToken = jwtFactory.generateToken(user.getDeviceId());
        return ResponseEntity.ok(new AccessToken(accessToken));
    }
}
