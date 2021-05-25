package play.laika.auth2.web.io;

import play.laika.auth2.domain.security.Role;

public class UserDto {

    private String deviceId;
    private String role;

    public UserDto() {
    }

    public UserDto(String deviceId, Role role) {
        this.deviceId = deviceId;
        this.role = role.name();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
