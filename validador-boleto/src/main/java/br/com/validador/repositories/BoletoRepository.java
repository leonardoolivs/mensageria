package br.com.validador.repositories;

import br.com.validador.entities.Boleto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoletoRepository extends JpaRepository<Boleto, Long> {

    public boolean existsByCodigoBarras(String codigoBarras);
}
