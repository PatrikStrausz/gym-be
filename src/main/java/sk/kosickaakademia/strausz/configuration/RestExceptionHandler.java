package sk.kosickaakademia.strausz.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import sk.kosickaakademia.strausz.api.rest.ErrorDto;
import sk.kosickaakademia.strausz.exception.BusinessException;

import javax.validation.ConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    //exception zalogovat ako internal server error


    Logger logger = Logger.getLogger(RestExceptionHandler.class.getName());


   @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleInternalServerError(Exception e){
        //vsetky chyby zalogovat a vratit 500 internal server error

       logger.log(Level.SEVERE, "ERROR "+HttpStatus.INTERNAL_SERVER_ERROR.value() + " " +e.getMessage());


       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorDto(HttpStatus.BAD_REQUEST.value(),e.getMessage()));
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorDto> handleBusinessException(BusinessException e){
        //vrati 400, message zo exception
        //TODO error dto vlozit do body

        logger.log(Level.SEVERE, "ERROR "+ HttpStatus.BAD_REQUEST.value() + " " +e.getMessage());


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDto(HttpStatus.BAD_REQUEST.value(),e.getMessage()));

    }



    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDto> handleConstraintViolationException(ConstraintViolationException e){

        logger.log(Level.SEVERE, "ERROR "+ HttpStatus.FORBIDDEN.value() + " " +e.getMessage() +" "+e.getConstraintViolations());


        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ErrorDto(HttpStatus.FORBIDDEN.value(), e.getMessage(),e.getConstraintViolations()));

    }

}
