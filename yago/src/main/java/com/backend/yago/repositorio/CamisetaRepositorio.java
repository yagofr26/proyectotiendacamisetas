package com.backend.yago.repositorio;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backend.yago.modelo.CamisetaVO;

@Repository
public interface CamisetaRepositorio extends CrudRepository<CamisetaVO, Integer> {
	Optional<CamisetaVO> findByNombre(String nombre);
	
}
