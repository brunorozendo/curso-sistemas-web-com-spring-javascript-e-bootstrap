package com.brunorozendo.brewer.services;

import com.brunorozendo.brewer.controllers.dto.CervejaDto;
import com.brunorozendo.brewer.model.entity.Cerveja;
import com.brunorozendo.brewer.model.repositories.CervejaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CervejaService {

  @Autowired
  CervejaRepository cervejaRepository;

  @Transactional
  public void salvar(CervejaDto cerveja) {
    cervejaRepository.save(cervejaDtoToEntity(cerveja));
  }



  private Cerveja  cervejaDtoToEntity(CervejaDto dto) {
    Cerveja cerveja = new Cerveja();
    cerveja.setId(dto.getId());
    cerveja.setSku(dto.getSku().toUpperCase());
    cerveja.setNome(dto.getNome());
    cerveja.setDescricao(dto.getDescricao());
    cerveja.setValor(dto.getValor());
    cerveja.setTeorAlcoolico(dto.getTeorAlcoolico());
    cerveja.setComissao(dto.getComissao());
    cerveja.setQtdEstoque(dto.getQtdEstoque());
    cerveja.setOrigem(dto.getOrigem());
    cerveja.setSabor(dto.getSabor());
    cerveja.setEstilo(dto.getEstilo());
    return cerveja;
  }

}
