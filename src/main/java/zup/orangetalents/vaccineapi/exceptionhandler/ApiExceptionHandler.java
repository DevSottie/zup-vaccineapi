package zup.orangetalents.vaccineapi.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;

@ControllerAdvice //diz que essa classe é um componente do spring onde vão ser colocados os tratamentos das exceções de todos os controladores
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        var campos = new ArrayList<ExceptionHandled.Campo>();

        for (ObjectError error : ex.getBindingResult().getAllErrors()){
            String nome = ((FieldError) error).getField();
            String mensagem = error.getDefaultMessage();

            campos.add(new ExceptionHandled.Campo(nome, mensagem));
        }

        var exception = new ExceptionHandled();

        exception.setStatus(status.value());
        exception.setTitle("Um ou mais campos inseridos estão inválidos");
        exception.setDataHora(LocalDateTime.now());
        exception.setCampos(campos);

        return super.handleExceptionInternal(ex,exception, headers, status, request);
    }
}
