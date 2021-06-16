package com.backend.yago.servicio;

import java.util.List;
import java.util.Optional;

import com.backend.yago.modelo.CamisetaVO;

public interface ServicioCamiseta {
	

	Optional<CamisetaVO> findByNombre(String nombre);

	<S extends CamisetaVO> S save(S entity);

	<S extends CamisetaVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<CamisetaVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<CamisetaVO> findAll();

	Iterable<CamisetaVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(CamisetaVO entity);

	void deleteAllById(Iterable<? extends Integer> ids);

	void deleteAll(Iterable<? extends CamisetaVO> entities);

	void deleteAll();

}