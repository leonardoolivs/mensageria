package br.com.boleto.exceptions.handler;

import br.com.boleto.exceptions.RegraNegocioException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionControllerHandler {

    @ExceptionHandler(RegraNegocioException.class)
    public ResponseEntity<ErroResponse> regraNegocio(RegraNegocioException e, HttpServletRequest http){

        HttpStatus status = HttpStatus.CONFLICT;

        ErroResponse erro = new ErroResponse(LocalDateTime.now(), status.value(), e.getMessage(), http.getRequestURI());

        return ResponseEntity.status(status).body(erro);
    }
}
