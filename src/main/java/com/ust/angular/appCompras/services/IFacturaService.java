package com.ust.angular.appCompras.services;

import java.util.List;
import java.util.Optional;

import com.ust.angular.appCompras.resources.Factura;

public interface IFacturaService {
	
	Factura saveFactura(Factura factura);
	
	List<Factura> getFacturas();
	
	Optional<Factura> getFactura(String id);
	
}
