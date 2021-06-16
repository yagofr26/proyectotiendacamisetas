package com.backend.yago.servicioImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.yago.modelo.CamisetaVO;
import com.backend.yago.repositorio.CamisetaRepositorio;
import com.backend.yago.servicio.ServicioCamiseta;

@Service
public class ServicioCamisetaImpl implements ServicioCamiseta {
	@Autowired
	CamisetaRepositorio cr;

	@Override
	public Optional<CamisetaVO> findByNombre(String nombre) {
		return cr.findByNombre(nombre);
	}

	@Override
	public <S extends CamisetaVO> S save(S entity) {
		return cr.save(entity);
	}

	@Override
	public <S extends CamisetaVO> Iterable<S> saveAll(Iterable<S> entities) {
		return cr.saveAll(entities);
	}
	
	
 
	

	@Override
	public Optional<CamisetaVO> findById(Integer id) {
		return cr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return cr.existsById(id);
	}

	@Override
	public Iterable<CamisetaVO> findAll() {
		return cr.findAll();
	}

	@Override
	public Iterable<CamisetaVO> findAllById(Iterable<Integer> ids) {
		return cr.findAllById(ids);
	}

	@Override
	public long count() {
		return cr.count();
	}

	@Override
	public void deleteById(Integer id) {
		cr.deleteById(id);
	}

	@Override
	public void delete(CamisetaVO entity) {
		cr.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		cr.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends CamisetaVO> entities) {
		cr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		cr.deleteAll();
	}
	

}
