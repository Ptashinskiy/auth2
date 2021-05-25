package play.laika.auth2.domain.security;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import play.laika.auth2.web.io.UserDto;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class User {

    @Id
    @Column(length = 36)
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @Column(nullable = false, unique = true)
    private String deviceId;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {
    }

    private User(String deviceId, Role role) {
        this.deviceId = deviceId;
        this.role = role;
    }

    public static User createUser(String deviceId) {
        return new User(deviceId, Role.ROLE_USER);
    }

    public static User createAdmin(String deviceId) {
        return new User(deviceId, Role.ROLE_ADMIN);
    }

    public UserDto toDto() {
        return new UserDto(deviceId, role);
    }
}
