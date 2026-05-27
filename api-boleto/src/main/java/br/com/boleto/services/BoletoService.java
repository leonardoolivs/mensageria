package br.com.boleto.services;

import br.com.boleto.entities.Boleto;
import br.com.boleto.repositories.BoletoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoletoService {

    private final BoletoRepository repository;

    @Transactional
    public Boleto criar(Boleto boleto){
        if(repository.existsByCodigoBarras(boleto.getCodigoBarras())){
            System.out.println("Ja existe meu véio, tenta outro código ai painho");
        }

        return repository.save(boleto);
    }
}
