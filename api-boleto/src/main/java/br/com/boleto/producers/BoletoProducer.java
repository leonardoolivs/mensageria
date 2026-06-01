package br.com.boleto.producers;

import br.com.boleto.dtos.BoletoDTO;
import br.com.avro.BoletoAvro;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BoletoProducer {

    @Value("${spring.kafka.topico-boleto}")
    public String topico;

    private final KafkaTemplate<String, BoletoAvro> kafkaTemplate;

    public void enviarMensagem(BoletoAvro avro){
        kafkaTemplate.send(topico, avro);
    }
}
