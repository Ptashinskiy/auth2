package play.laika.auth2.exceptions;

public class UserException extends RuntimeException {

    public UserException(String message) {
        super(message);
    }

    public static UserException suchUserAlreadyExist(String deviceId) {
        return new UserException("User with device id " + deviceId + " already exist!");
    }

    public static UserException userNotFound(String deviceId) {
        return new UserException("User with device id " + deviceId + " not found");
    }
}
