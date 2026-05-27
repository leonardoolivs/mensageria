package br.com.boleto.mappers;

import br.com.boleto.dtos.BoletoDTO;
import br.com.boleto.entities.Boleto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface BoletoMapper {

    BoletoDTO toDTO(Boleto boleto);

    Boleto toEntity(BoletoDTO dto);

}
