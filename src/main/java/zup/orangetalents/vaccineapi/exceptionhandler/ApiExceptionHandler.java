package zup.orangetalents.vaccineapi.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice //diz que essa classe é um componente do spring onde vão ser colocados os tratamentos das exceções de todos os controladores
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        var exception = new ExceptionHandled();

        exception.setStatus(status.value());
        exception.setTitle("Um ou mais campos inseridos estão inválidos");
        exception.setDataHora(LocalDateTime.now());

        return super.handleExceptionInternal(ex,exception, headers, status, request);
    }
}
