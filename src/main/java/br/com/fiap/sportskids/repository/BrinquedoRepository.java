package br.com.fiap.sportskids.repository;

import br.com.fiap.sportskids.entity.Brinquedo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrinquedoRepository extends JpaRepository<Brinquedo, Long> {
}
