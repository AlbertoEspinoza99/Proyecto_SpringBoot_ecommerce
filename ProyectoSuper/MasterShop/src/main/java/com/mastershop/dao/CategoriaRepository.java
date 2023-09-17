package com.mastershop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mastershop.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
