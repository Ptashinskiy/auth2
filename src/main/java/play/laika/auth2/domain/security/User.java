package play.laika.auth2.domain.security;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "user_entity")
public class User {

    @Id
    private String id;

    @Column(nullable = false, unique = true)
    private String deviceId;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {
    }

    public User(String deviceId, String password) {
        this.id = UUID.randomUUID().toString();
        this.deviceId = deviceId;
        this.password = password;
        this.role = Role.ROLE_USER;
    }
}
