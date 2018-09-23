package com.brunorozendo.brewer.services;

import com.brunorozendo.brewer.controllers.dto.EstiloDto;
import com.brunorozendo.brewer.model.entity.Estilo;
import com.brunorozendo.brewer.model.repositories.EstiloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstiloService {

  @Autowired
  EstiloRepository estiloRepository;

  @Transactional
  public void salvar(EstiloDto estilo) {
    estiloRepository.save(estiloDtoToEntity(estilo));
  }



  private Estilo  estiloDtoToEntity(EstiloDto dto) {
    Estilo estilo = new Estilo();
    estilo.setId(dto.getId());
    estilo.setNome(dto.getNome());
    return estilo;
  }

}
