package br.com.boleto.mapper;

import br.com.boleto.dto.BoletoDTO;
import br.com.boleto.entities.Boleto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoletoMapper {

    BoletoDTO toDTO(Boleto boleto);

    Boleto toEntity(BoletoDTO dto);

}
