package play.laika.auth2.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import play.laika.auth2.domain.security.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByDeviceId(String deviceId);

    boolean existsByDeviceId(String deviceId);
}
