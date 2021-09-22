package sk.kosickaakademia.strausz.configuration;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    //exception zalogovat ako internal server error


  /*  @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleInternalServerError(Exception e){
        //vsetky chyby zalogovat a vratit 500 internal server error

    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorDto> handleBusinessException(BusinessException e){
        //vrati 400, message zo exception
        //TODO error dto vlozit do body

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body().build();

    }

  //constraint violation exception
*/
}
