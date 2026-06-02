package br.com.validador.mappers;

import br.com.avro.BoletoAvro;
import br.com.validador.entities.Boleto;
import br.com.validador.entities.enums.StatusBoleto;

public class BoletoMapper {

    public static Boleto toEntity(BoletoAvro avro){
        return new Boleto(
                avro.getCodigoBarras().toString(),
                StatusBoleto.values()[avro.getSituacaoBoleto()]);
    }
}
