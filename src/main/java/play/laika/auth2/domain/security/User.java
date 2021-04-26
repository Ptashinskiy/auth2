package play.laika.auth2.domain.security;

import play.laika.auth2.web.io.UserDto;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "user_entity")
public class User {

    @Id
    private String id;

    @Column(nullable = false, unique = true)
    private String deviceId;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {
    }

    public User(String deviceId) {
        this.id = UUID.randomUUID().toString();
        this.deviceId = deviceId;
        this.role = Role.ROLE_USER;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public UserDto toDto() {
        return new UserDto(deviceId);
    }
}
