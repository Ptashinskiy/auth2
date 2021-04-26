package play.laika.auth2.web.io;

public class RegisterNewUserRequest {

    private String deviceId;

    public RegisterNewUserRequest() {
    }

    public RegisterNewUserRequest(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
