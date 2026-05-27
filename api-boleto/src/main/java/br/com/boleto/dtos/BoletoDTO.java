package br.com.boleto.dtos;

import br.com.boleto.entities.enums.StatusBoleto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoletoDTO {

    private Long id;

    private String codigoBarras;

    private StatusBoleto status;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

}