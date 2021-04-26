package play.laika.auth2.web.io;

public class UserDto {

    private String deviceId;

    public UserDto() {
    }

    public UserDto(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
