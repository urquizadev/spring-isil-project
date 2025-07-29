package com.isilSoftSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isilSoftSpring.entity.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador,Integer> {
	List<Colaborador> findAll();
}
