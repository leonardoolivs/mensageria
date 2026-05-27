package br.com.boleto.exceptions.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErroResponse {

    private LocalDateTime timestamp;
    private Integer status;
    private String message;
    private String path;

}
