package com.example.tienda.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tienda.entities.Producto;
import com.example.tienda.services.ProductoServiceImpl;

@RestController
@RequestMapping ("/productos/*")
@CrossOrigin (value = "http://localhost:4200")
public class ProductoController {

	@Autowired
	private ProductoServiceImpl serviceImpl;
	
	@GetMapping
	public ResponseEntity< List <Producto>> getAll()
	{
		return ResponseEntity.ok(serviceImpl.getAll());
	}
	@GetMapping("{id}")
	public ResponseEntity<Producto> getById(@PathVariable Long id)
	{
		Optional<Producto> optionalProducto = serviceImpl.getById(id);
		if (optionalProducto.isPresent()) {
			return ResponseEntity.ok(optionalProducto.orElseThrow());
		}
		return ResponseEntity.notFound().build();
	}
	@PostMapping
	public ResponseEntity<Producto> create(@RequestBody Producto producto) 
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceImpl.save(producto));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Producto> update(@RequestBody Producto producto, @PathVariable Long id)
	{
		Optional<Producto> optionalProducto = serviceImpl.getById(id);
		if (optionalProducto.isPresent()) 
		{
			Producto productoDB = optionalProducto.orElseThrow();
			productoDB.setNombre(producto.getNombre());
			productoDB.setPrecio(producto.getPrecio());
			productoDB.setDescripcion(producto.getDescripcion());
			productoDB.setStock(producto.getStock());
			return ResponseEntity.status(HttpStatus.CREATED).body(serviceImpl.save(productoDB));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping ("{id}")
	public ResponseEntity<Producto> delete (@PathVariable Long id)
	{
		Optional<Producto> optionalProducto = serviceImpl.getById(id);
		if (optionalProducto.isPresent()) 
		{
			Producto productoDeleted = serviceImpl.deleteById(id).orElseThrow();
			return ResponseEntity.status(HttpStatus.OK).body(productoDeleted);
		}
		return ResponseEntity.notFound().build();
	}
	
	
}
