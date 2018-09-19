package com.brunorozendo.brewer.model.repositories;

import com.brunorozendo.brewer.model.entity.Cerveja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CervejaRepository extends JpaRepository<Cerveja, Integer> {
}
