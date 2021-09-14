package sk.kosickaakademia.strausz.api.rest;

import javax.validation.ConstraintViolation;
import java.util.List;

public class ErrorDto {

    private String errorCode;

    private String message;

    private List<ConstraintViolation> constraintViolation;
}
