package sk.kosickaakademia.strausz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "token_expired")
public class JWTAuthorizationExpiredException extends RuntimeException {

    public JWTAuthorizationExpiredException(String message, Throwable cause) {
        super(message, cause);
    }
}
