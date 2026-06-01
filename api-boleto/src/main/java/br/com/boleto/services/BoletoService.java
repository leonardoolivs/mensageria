package br.com.boleto.services;

import br.com.boleto.dtos.BoletoDTO;
import br.com.boleto.entities.Boleto;
import br.com.boleto.exceptions.RegraNegocioException;
import br.com.boleto.mappers.BoletoMapper;
import br.com.boleto.producers.BoletoProducer;
import br.com.boleto.repositories.BoletoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoletoService {

    private final BoletoRepository repository;
    private final BoletoProducer producer;
    private final BoletoMapper mapper;

    @Transactional
    public BoletoDTO criar(Boleto boleto){
        if(repository.existsByCodigoBarras(boleto.getCodigoBarras())){
            throw new RegraNegocioException(String.format("Código de barras '%s' já existe", boleto.getCodigoBarras()));
        }

        boleto = repository.save(boleto);

        producer.enviarMensagem(mapper.toAvro(boleto));

        return mapper.toDTO(boleto);
    }
}
