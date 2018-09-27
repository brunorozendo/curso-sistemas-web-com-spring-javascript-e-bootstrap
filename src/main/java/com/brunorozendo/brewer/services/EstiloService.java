package com.brunorozendo.brewer.services;

import com.brunorozendo.brewer.controllers.dto.EstiloDto;
import com.brunorozendo.brewer.model.entity.Estilo;
import com.brunorozendo.brewer.model.repositories.EstiloRepository;
import com.brunorozendo.brewer.services.exception.DuplicateNameField;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstiloService {

  @Autowired
  EstiloRepository estiloRepository;

  /**
   * Resposavél por: validara gravar dos dados.
   * @param estilo instância de um @see EstiloDto
   * @return Estilo
   */
  @Transactional
  public Estilo salvar(EstiloDto estilo) {

    Optional<Estilo> byNomeIgnoreCase = estiloRepository.findByNomeIgnoreCase(estilo.getNome());
    if (byNomeIgnoreCase.isPresent()) {
      throw new DuplicateNameField("nome");
    }
    return  estiloRepository.saveAndFlush(estiloDtoToEntity(estilo));
  }


  private Estilo estiloDtoToEntity(EstiloDto dto) {
    Estilo estilo = new Estilo();
    estilo.setId(dto.getId());
    estilo.setNome(dto.getNome());
    return estilo;
  }

}
