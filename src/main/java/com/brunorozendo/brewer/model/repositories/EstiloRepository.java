package com.brunorozendo.brewer.model.repositories;

import com.brunorozendo.brewer.model.entity.Estilo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstiloRepository  extends JpaRepository<Estilo, Integer> {

  Optional<Estilo> findByNomeIgnoreCase(String nome);

}
