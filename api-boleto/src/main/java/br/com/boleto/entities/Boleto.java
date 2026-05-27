package br.com.boleto.entities;

import br.com.boleto.entities.enums.StatusBoleto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_BOLETO")
public class Boleto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_barras", unique = true)
    private String codigoBarras;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusBoleto status;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @PrePersist
    public void prePersist(){
        status = StatusBoleto.CRIADO;
        dataCriacao = LocalDateTime.now();
    }

}