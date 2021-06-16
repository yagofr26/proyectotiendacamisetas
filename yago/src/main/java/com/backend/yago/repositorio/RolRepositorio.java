package com.backend.yago.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backend.yago.modelo.RolVO;
@Repository
public interface RolRepositorio extends CrudRepository<RolVO, Integer> {

}
