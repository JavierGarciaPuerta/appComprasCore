package com.ust.angular.appCompras.repository;

import com.ust.angular.appCompras.resources.Factura;

public interface IFacturaRepositoryCustom {
	
	Factura getMaxFactId();
	
	long updateFactura(String nombre, String proveedor);

}
