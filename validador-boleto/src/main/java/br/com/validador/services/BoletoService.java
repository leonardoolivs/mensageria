package br.com.validador.services;

import br.com.validador.entities.Boleto;
import br.com.validador.entities.enums.StatusBoleto;
import br.com.validador.kafka.producers.NotificacaoProducer;
import br.com.validador.mappers.BoletoMapper;
import br.com.validador.repositories.BoletoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BoletoService {

    private final BoletoRepository repository;
    private final NotificacaoProducer producer;

    public void validar(Boleto boleto){
        int numeroInicialBoleto = Integer.parseInt(boleto.getCodigoBarras().substring(0,1));
        if(numeroInicialBoleto % 2 == 0){
            boleto.setStatus(StatusBoleto.ERRO_PAGAMENTO);
        }else{
            boleto.setStatus(StatusBoleto.PAGO);
        }

        boleto.setDataAtualizacao(LocalDateTime.now());
        repository.save(boleto);
        producer.enviarMensagem(BoletoMapper.toAvro(boleto));
    }
}
