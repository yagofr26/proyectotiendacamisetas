package com.backend.yago.repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backend.yago.modelo.UsuarioVO;


@Repository
public interface UsuarioRepositorio extends CrudRepository<UsuarioVO, Integer> {
	Optional<UsuarioVO> findByUsername(String username);

}
