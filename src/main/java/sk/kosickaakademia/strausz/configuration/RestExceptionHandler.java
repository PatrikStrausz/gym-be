package sk.kosickaakademia.strausz.configuration;

import com.auth0.jwt.exceptions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import sk.kosickaakademia.strausz.api.rest.ConstraintViolationDto;
import sk.kosickaakademia.strausz.api.rest.ErrorDto;
import sk.kosickaakademia.strausz.exception.BusinessException;
import sk.kosickaakademia.strausz.exception.InvalidCredentialsException;
import sk.kosickaakademia.strausz.exception.InvalidLoginDataException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleInternalServerError(Exception e) {


        logger.error("Internal server error", e);


        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
    }


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorDto> handleDataIntegrityViolationException(DataIntegrityViolationException e) {


        logger.error("Data Integrity error", e);

        String message;
        int code = 500;

        if (Objects.requireNonNull(e.getMessage()).contains("unq_username")) {
            message = "Username already exists";
            code = 400;
        } else if (Objects.requireNonNull(e.getMessage()).contains("unq_email")) {
            message = "Email already exists";
            code = 400;
        } else {
            message = "Internal server error";
        }


        return ResponseEntity.status(code)
                .body(new ErrorDto(code, message));
    }


    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorDto> handleBusinessException(BusinessException e) {


        logger.error("Business exception error", e);


        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(HttpStatus.BAD_REQUEST.value(), e.getMessage()));

    }


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDto> handleConstraintViolationException(ConstraintViolationException e) {


        logger.warn("Constraint violation error", e);

        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        ConstraintViolation<?> next = constraintViolations.iterator().next();


        ConstraintViolationDto dto = new ConstraintViolationDto(next.getInvalidValue()
                , next.getMessage(), next.getConstraintDescriptor());

        List<ConstraintViolationDto> constraintViolationDtos = new ArrayList<>();
        constraintViolationDtos.add(dto);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(HttpStatus.BAD_REQUEST.value(), e.getMessage(), constraintViolationDtos));

    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ErrorDto> handleInvalidCredentialsException(InvalidCredentialsException e) {

        logger.error("Invalid Credentials", e);

        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(new ErrorDto(HttpStatus.FORBIDDEN.value(), e.getMessage()));
    }


    @ExceptionHandler(InvalidLoginDataException.class)
    public ResponseEntity<ErrorDto> handleInvalidLoginDataException(InvalidLoginDataException e) {

        logger.warn("Invalid Login Data", e);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(HttpStatus.BAD_REQUEST.value(), e.getMessage()));

    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex
            , HttpHeaders headers, HttpStatus status, WebRequest request) {
        String errorMessage = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        List<String> validationList = ex.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());

        logger.warn("Validation error list : " + validationList);
        logger.warn("Error message : " + errorMessage);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(HttpStatus.BAD_REQUEST.value(), errorMessage));

    }


    @ExceptionHandler({SignatureVerificationException.class, AlgorithmMismatchException.class})
    public ResponseEntity<ErrorDto> handleInvalidTokenException(Exception e) {


        logger.error("{}", e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(HttpStatus.BAD_REQUEST.value(), e.getMessage()));

    }


    @ExceptionHandler(TokenExpiredException.class)
    public ResponseEntity<ErrorDto> handleExpiredTokenException(TokenExpiredException e) {


        logger.warn("Token expired", e);


        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ErrorDto(HttpStatus.UNAUTHORIZED.value(), e.getMessage()));

    }

    /*    @ExceptionHandler(AlgorithmMismatchException.class)
        public ResponseEntity<ErrorDto> AlgorithmMismatchException(AlgorithmMismatchException e) {


            logger.error("{}", e.getMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorDto(HttpStatus.BAD_REQUEST.value(), e.getMessage()));

        }
    */
    @ExceptionHandler(InvalidClaimException.class)
    public ResponseEntity<ErrorDto> InvalidClaimException(InvalidClaimException e) {


        logger.error("Invalid claim", e);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(HttpStatus.BAD_REQUEST.value(), e.getMessage()));

    }

    @ExceptionHandler(JWTCreationException.class)
    public ResponseEntity<ErrorDto> JWTCreationException(JWTCreationException e) {


        logger.error("JWT Creation error", e);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(HttpStatus.BAD_REQUEST.value(), e.getMessage()));

    }

    @ExceptionHandler(JWTDecodeException.class)
    public ResponseEntity<ErrorDto> JWTDecodeException(JWTDecodeException e) {


        logger.error("JWT Decoding error", e);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(HttpStatus.BAD_REQUEST.value(), e.getMessage()));

    }

    @ExceptionHandler(JWTVerificationException.class)
    public ResponseEntity<ErrorDto> JWTVerificationException(JWTVerificationException e) {


        logger.error("JWT Verification error", e);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(HttpStatus.BAD_REQUEST.value(), e.getMessage()));

    }

    @ExceptionHandler(SignatureGenerationException.class)
    public ResponseEntity<ErrorDto> SignatureGenerationException(SignatureGenerationException e) {


        logger.error("Signature generation error", e);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(HttpStatus.BAD_REQUEST.value(), e.getMessage()));

    }


}
