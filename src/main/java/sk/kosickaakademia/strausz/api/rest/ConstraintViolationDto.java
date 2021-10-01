package sk.kosickaakademia.strausz.api.rest;

import javax.validation.metadata.ConstraintDescriptor;

public class ConstraintViolationDto {

    private Object invalidValue;

    private String message;

    private ConstraintDescriptor<?> constraintDescriptor;


    public ConstraintViolationDto(Object invalidValue, String message, ConstraintDescriptor<?> constraintDescriptor) {
        this.invalidValue = invalidValue;
        this.message = message;
        this.constraintDescriptor = constraintDescriptor;
    }

    public Object getInvalidValue() {
        return invalidValue;
    }

    public void setInvalidValue(Object invalidValue) {
        this.invalidValue = invalidValue;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ConstraintDescriptor<?> getConstraintDescriptor() {
        return constraintDescriptor;
    }

    public void setConstraintDescriptor(ConstraintDescriptor<?> constraintDescriptor) {
        this.constraintDescriptor = constraintDescriptor;
    }
}
