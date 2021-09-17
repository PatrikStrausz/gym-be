package sk.kosickaakademia.strausz.api.rest;

import javax.validation.ConstraintViolation;
import java.util.List;

public class ErrorDto{

    private String errorCode;

    private String message;

    private List<ConstraintViolation> constraintViolation;

    public ErrorDto(String errorCode, String message, List<ConstraintViolation> constraintViolation) {
        this.errorCode = errorCode;
        this.message = message;
        this.constraintViolation = constraintViolation;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ConstraintViolation> getConstraintViolation() {
        return constraintViolation;
    }

    public void setConstraintViolation(List<ConstraintViolation> constraintViolation) {
        this.constraintViolation = constraintViolation;
    }
}
