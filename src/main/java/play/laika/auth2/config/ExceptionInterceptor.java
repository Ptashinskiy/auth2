package play.laika.auth2.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import play.laika.auth2.web.io.MessageResponse;

@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<MessageResponse> handleException(Throwable e) {
        return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
    }
}
