package sk.kosickaakademia.strausz.api.rest;

import java.util.List;

public class ErrorDto {

    private int errorCode;

    private String message;

    private List<ConstraintViolationDto> constraintViolation;

    public ErrorDto(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public ErrorDto(int errorCode, String message, List<ConstraintViolationDto> constraintViolation) {
        this.errorCode = errorCode;
        this.message = message;
        this.constraintViolation = constraintViolation;
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

    public List<ConstraintViolationDto> getConstraintViolation() {
        return constraintViolation;
    }

    public void setConstraintViolation(List<ConstraintViolationDto> constraintViolation) {
        this.constraintViolation = constraintViolation;
    }
}
