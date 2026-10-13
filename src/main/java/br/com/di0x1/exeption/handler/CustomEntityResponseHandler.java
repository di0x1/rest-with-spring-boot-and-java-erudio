package br.com.di0x1.exeption.handler;

import br.com.di0x1.exeption.ExeptionResponse;
import br.com.di0x1.exeption.ResouceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomEntityResponseHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExeptionResponse> handleAllExeptions(Exception ex, WebRequest rquest){
        ExeptionResponse response = new ExeptionResponse(
                new Date(),
                ex.getMessage(),
                rquest.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResouceNotFoundException.class)
    public final ResponseEntity<ExeptionResponse> handleNotFoundExeptions(Exception ex, WebRequest rquest){
        ExeptionResponse response = new ExeptionResponse(
                new Date(),
                ex.getMessage(),
                rquest.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
