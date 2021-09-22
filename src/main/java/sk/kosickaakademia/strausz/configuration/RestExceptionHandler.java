package sk.kosickaakademia.strausz.configuration;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    //exception zalogovat ako internal server error



   /* @ExceptionHandler({FoodNotFoundException.class, ContentNotAllowedException.class})
    public final ResponseEntity<ErrorDto> handleExceptions(Exception ex, WebRequest request) {

        HttpHeaders headers = new HttpHeaders();

        if (ex instanceof FoodNotFoundException) {
            HttpStatus status = HttpStatus.NOT_FOUND;
            FoodNotFoundException foodNotFoundException = (FoodNotFoundException) ex;

            return handleUserNotFoundException(foodNotFoundException, headers, status, request);
        } else if (ex instanceof ContentNotAllowedException) {
            HttpStatus status = HttpStatus.BAD_REQUEST;
            ContentNotAllowedException cnae = (ContentNotAllowedException) ex;

            return handleContentNotAllowedException(cnae, headers, status, request);
        } else {
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            return handleExceptionInternal(ex, null, headers, status, request);
        }

    }


    protected ResponseEntity<ErrorDto> handleUserNotFoundException(FoodNotFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = Collections.singletonList(ex.getMessage());
        return handleExceptionInternal(ex, new ErrorDto(status.value(), ex.getMessage(),ex), headers, status, request);
    }

    protected ResponseEntity<ErrorDto> handleContentNotAllowedException(ContentNotAllowedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errorMessages = ex.getErrors()
                .stream()
                .map(contentError -> contentError.getObjectName() + " " + contentError.getDefaultMessage())
                .collect(Collectors.toList());

        return handleExceptionInternal(ex, new ErrorDto(status.value(), ex.getMessage(),ex), headers, status, request);
    }

    protected ResponseEntity<ErrorDto> handleExceptionInternal(Exception ex, ErrorDto body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }

        return new ResponseEntity<>(body, headers, status);
    }
*/
}
