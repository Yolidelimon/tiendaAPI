package com.example.tienda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tienda.entities.Producto;

public interface ProductoRepository  extends JpaRepository <Producto, Long>{
}
