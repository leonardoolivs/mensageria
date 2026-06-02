package br.com.validador.kafka;

import br.com.validador.mappers.BoletoMapper;
import br.com.validador.services.BoletoService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import br.com.avro.BoletoAvro;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoletoConsumer {

    private static final Logger logger = LoggerFactory.getLogger(BoletoConsumer.class);

    private final BoletoService service;

    @KafkaListener(topics = "${spring.kafka.topico-boleto}", groupId = "${spring.kafka.consumer.group-id}")
    public void consomeBoleto(BoletoAvro boleto){
        logger.info("Consumindo mensagem -> {}", boleto);
        service.validar(BoletoMapper.toEntity(boleto));
    }

}
