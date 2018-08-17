package com.ust.angular.appCompras.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ust.angular.appCompras.resources.Factura;

public interface IFacturaRepository extends MongoRepository<Factura, String> {
	
	@SuppressWarnings("unchecked")
	Factura insert(Factura nuevaFactura);
	
	List<Factura> findAll();
	
	Optional<Factura> findById(String id);
	
}
