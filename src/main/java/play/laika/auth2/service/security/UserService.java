package play.laika.auth2.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import play.laika.auth2.domain.repository.UserRepository;
import play.laika.auth2.domain.security.User;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User createNewUser(String deviceId, String password) {
        if (userRepository.existsByDeviceId(deviceId)) {
            throw new RuntimeException();
        }
        return userRepository.save(new User(deviceId, passwordEncoder.encode(password)));
    }

    @Transactional(readOnly = true)
    public User findByDeviceId(String deviceId) {
        return userRepository.findByDeviceId(deviceId).orElseThrow(RuntimeException::new);
    }
}
