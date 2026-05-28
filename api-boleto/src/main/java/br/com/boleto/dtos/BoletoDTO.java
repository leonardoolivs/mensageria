package br.com.boleto.dtos;

import br.com.boleto.entities.enums.StatusBoleto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoletoDTO {

    private Long id;

    @NotBlank
    private String codigoBarras;

    private StatusBoleto status;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

}