package play.laika.auth2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import play.laika.auth2.domain.repository.UserRepository;
import play.laika.auth2.domain.security.User;
import play.laika.auth2.exceptions.UserException;
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
        if (userRepository.existsByDeviceId(deviceId)) throw UserException.suchUserAlreadyExist(deviceId);
        return userRepository.save(User.createUser(deviceId)).toDto();
    }

    public UserDto createNewAdmin(String deviceId) {
        if (userRepository.existsByDeviceId(deviceId)) throw UserException.suchUserAlreadyExist(deviceId);
        return userRepository.save(User.createAdmin(deviceId)).toDto();
    }

    @Transactional(readOnly = true)
    public UserDto findByDeviceId(String deviceId) {
        return userRepository.findByDeviceId(deviceId).orElseThrow(() -> UserException.userNotFound(deviceId)).toDto();
    }
}
