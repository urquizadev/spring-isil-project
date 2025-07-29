package com.isilSoftSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isilSoftSpring.entity.Tienda;


@Repository
public interface TiendaRepository extends JpaRepository<Tienda,Integer>{
	Tienda findById(int id);
	
	List<Tienda> findAll();
	
	List<Tienda> findByDistritoContains(String distrito);
	
	Tienda findByDireccion(String direccion);
}
