package sk.kosickaakademia.strausz.api.rest;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class ErrorDto <T>{

    private int errorCode;

    private String message;

    private Set<ConstraintViolation<T>> constraintViolation;

    public ErrorDto(int errorCode, String message, Set<ConstraintViolation<T>> constraintViolation) {
        this.errorCode = errorCode;
        this.message = message;
        this.constraintViolation = constraintViolation;
    }

    public ErrorDto(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Set<ConstraintViolation<T>> getConstraintViolation() {
        return constraintViolation;
    }

    public void setConstraintViolation(Set<ConstraintViolation<T>> constraintViolation) {
        this.constraintViolation = constraintViolation;
    }
}
