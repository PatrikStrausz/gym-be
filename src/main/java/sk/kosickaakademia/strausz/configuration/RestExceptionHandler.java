package sk.kosickaakademia.strausz.configuration;

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
import sk.kosickaakademia.strausz.exception.InvalidLoginDataException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.*;
import java.util.stream.Collectors;


@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);
    private static final String UNQ_USERNAME = "unq_username";
    private static final String UNQ_EMAIL = "unq_email";
    private static final String UNQ_USER_DETAILS_USER_ID = "user_details_user_id_key";


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleInternalServerError(Exception e) {


        logger.error("Internal server error", e);


        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
    }


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorDto> handleDataIntegrityViolationException(DataIntegrityViolationException e) {


        logger.error("Data Integrity error", e);


        if (Objects.requireNonNull(e.getMessage()).contains(UNQ_USERNAME)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorDto(HttpStatus.BAD_REQUEST.value(), "Username already exists"));
        } else if (Objects.requireNonNull(e.getMessage()).contains(UNQ_EMAIL)) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorDto(HttpStatus.BAD_REQUEST.value(), "Email already exists"));
        } else if (Objects.requireNonNull(e.getMessage()).contains(UNQ_USER_DETAILS_USER_ID)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorDto(HttpStatus.BAD_REQUEST.value(), "User details with this user id already exists"));
        } else {
            return handleInternalServerError(e);
        }

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

        Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
        List<ConstraintViolationDto> constraintViolationDtos = new ArrayList<>();

        while (iterator.hasNext()) {
            ConstraintViolation<?> next = iterator.next();
            ConstraintViolationDto dto = new ConstraintViolationDto(next.getInvalidValue()
                    , next.getMessage(), next.getConstraintDescriptor());
            constraintViolationDtos.add(dto);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(HttpStatus.BAD_REQUEST.value(), e.getMessage(), constraintViolationDtos));

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

}
