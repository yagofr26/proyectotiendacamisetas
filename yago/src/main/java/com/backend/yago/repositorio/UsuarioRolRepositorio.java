package com.backend.yago.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backend.yago.modelo.UsuarioRolVO;

@Repository
public interface UsuarioRolRepositorio extends CrudRepository<UsuarioRolVO, Integer> {

}
