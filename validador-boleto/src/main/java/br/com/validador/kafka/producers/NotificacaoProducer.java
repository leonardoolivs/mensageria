package br.com.validador.kafka.producers;

import br.com.avro.BoletoAvro;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificacaoProducer {

    @Value("${spring.kafka.topico-notificacao}")
    public String topico;

    private final KafkaTemplate<String, BoletoAvro> kafkaTemplate;

    public void enviarMensagem(BoletoAvro avro){
        kafkaTemplate.send(topico, avro);
    }
}
