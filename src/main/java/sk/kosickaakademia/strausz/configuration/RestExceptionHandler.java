package sk.kosickaakademia.strausz.configuration;

import com.auth0.jwt.exceptions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
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
import java.util.Set;
import java.util.stream.Collectors;


@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleInternalServerError(Exception e) {


        logger.error("{}", e.getMessage());


        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
    }


    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorDto> handleBusinessException(BusinessException e) {


        logger.error("{}", e.getMessage());


        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(HttpStatus.BAD_REQUEST.value(), e.getMessage()));

    }


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDto> handleConstraintViolationException(ConstraintViolationException e) {


        logger.warn("{}", e.getMessage());

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


        logger.error("{}", e.getMessage());

        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(new ErrorDto(HttpStatus.FORBIDDEN.value(), e.getMessage()));

    }


    @ExceptionHandler(InvalidLoginDataException.class)
    public ResponseEntity<ErrorDto> handleInvalidLoginDataException(InvalidLoginDataException e) {


        logger.warn("{}", e.getMessage());

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


    @ExceptionHandler(SignatureVerificationException.class)
    public ResponseEntity<ErrorDto> SignatureVerificationException(SignatureVerificationException e) {


        logger.error("{}", e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(HttpStatus.BAD_REQUEST.value(), e.getMessage()));

    }

    @ExceptionHandler(TokenExpiredException.class)
    public ResponseEntity<ErrorDto> TokenExpiredException(TokenExpiredException e) {


        logger.error("{}", e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(HttpStatus.BAD_REQUEST.value(), e.getMessage()));

    }

    @ExceptionHandler(AlgorithmMismatchException.class)
    public ResponseEntity<ErrorDto> AlgorithmMismatchException(AlgorithmMismatchException e) {


        logger.error("{}", e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(HttpStatus.BAD_REQUEST.value(), e.getMessage()));

    }

    @ExceptionHandler(InvalidClaimException.class)
    public ResponseEntity<ErrorDto> InvalidClaimException(InvalidClaimException e) {


        logger.error("{}", e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(HttpStatus.BAD_REQUEST.value(), e.getMessage()));

    }

    @ExceptionHandler(JWTCreationException.class)
    public ResponseEntity<ErrorDto> JWTCreationException(JWTCreationException e) {


        logger.error("{}", e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(HttpStatus.BAD_REQUEST.value(), e.getMessage()));

    }

    @ExceptionHandler(JWTDecodeException.class)
    public ResponseEntity<ErrorDto> JWTDecodeException(JWTDecodeException e) {


        logger.error("{}", e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(HttpStatus.BAD_REQUEST.value(), e.getMessage()));

    }

    @ExceptionHandler(JWTVerificationException.class)
    public ResponseEntity<ErrorDto> JWTVerificationException(JWTVerificationException e) {


        logger.error("{}", e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(HttpStatus.BAD_REQUEST.value(), e.getMessage()));

    }

    @ExceptionHandler(SignatureGenerationException.class)
    public ResponseEntity<ErrorDto> SignatureGenerationException(SignatureGenerationException e) {


        logger.error("{}", e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(HttpStatus.BAD_REQUEST.value(), e.getMessage()));

    }


}
