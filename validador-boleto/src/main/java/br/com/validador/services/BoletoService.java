package br.com.validador.services;

import br.com.validador.entities.Boleto;
import br.com.validador.entities.enums.StatusBoleto;
import br.com.validador.repositories.BoletoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BoletoService {

    private final BoletoRepository repository;

    public void validar(Boleto boleto){
        int numeroInicialBoleto = Integer.parseInt(boleto.getCodigoBarras().substring(0,1));
        if(numeroInicialBoleto % 2 == 0){
            boletoComErro(boleto);
        }else{
            boletoSucesso(boleto);
        }
    }

    public void boletoComErro(Boleto boleto){
        boleto.setStatus(StatusBoleto.ERRO_PAGAMENTO);
        boleto.setDataAtualizacao(LocalDateTime.now());
        repository.save(boleto);
    }

    public void boletoSucesso(Boleto boleto){
        boleto.setStatus(StatusBoleto.PAGO);
        boleto.setDataAtualizacao(LocalDateTime.now());
        repository.save(boleto);
    }
}
