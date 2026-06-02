package br.com.validador.kafka;

import org.slf4j.Logger;
import br.com.avro.BoletoAvro;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BoletoConsumer {

    public static final Logger logger = LoggerFactory.getLogger(BoletoConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topico-boleto}", groupId = "${spring.kafka.consumer.group-id}")
    public void consomeBoleto(BoletoAvro boleto){
        logger.info("Consumindo mensagem -> {}", boleto);
    }

}
