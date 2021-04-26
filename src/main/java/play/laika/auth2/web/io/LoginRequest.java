package play.laika.auth2.web.io;

public class LoginRequest {

    private String deviceId;

    public LoginRequest() {
    }

    public LoginRequest(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
