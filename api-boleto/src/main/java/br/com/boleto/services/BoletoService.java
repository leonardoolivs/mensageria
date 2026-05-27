package br.com.boleto.services;

import br.com.boleto.dtos.BoletoDTO;
import br.com.boleto.entities.Boleto;
import br.com.boleto.mappers.BoletoMapper;
import br.com.boleto.repositories.BoletoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoletoService {

    private final BoletoRepository repository;
    private final BoletoMapper mapper;

    @Transactional
    public BoletoDTO criar(Boleto boleto){
        if(repository.existsByCodigoBarras(boleto.getCodigoBarras())){
            System.out.println("Ja existe meu véio, tenta outro código ai painho");
        }

        boleto = repository.save(boleto);

        return mapper.toDTO(boleto);
    }
}
