package play.laika.auth2.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import play.laika.auth2.domain.repository.UserRepository;
import play.laika.auth2.domain.security.User;
import play.laika.auth2.web.io.UserDto;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserDto createNewUser(String deviceId) {
        if (userRepository.existsByDeviceId(deviceId)) {
            throw new RuntimeException();
        }
        return userRepository.save(new User(deviceId)).toDto();
    }

    @Transactional(readOnly = true)
    public User findByDeviceId(String deviceId) {
        return userRepository.findByDeviceId(deviceId).orElseThrow(RuntimeException::new);
    }
}
