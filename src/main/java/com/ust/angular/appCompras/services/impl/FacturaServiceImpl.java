package com.ust.angular.appCompras.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.angular.appCompras.repository.IFacturaRepository;
import com.ust.angular.appCompras.resources.Factura;
import com.ust.angular.appCompras.services.IFacturaService;

@Service
public class FacturaServiceImpl implements IFacturaService {
	
	private IFacturaRepository iFacturaRepository;
	
	@Autowired
	private void facturaServiceImpl(IFacturaRepository facturaRepository) {
		this.iFacturaRepository = facturaRepository;
	}
	
	@Override
	public Factura saveFactura(Factura factura) {
		return iFacturaRepository.insert(factura);
	}
	
	@Override
	public List<Factura> getFacturas() {
		return iFacturaRepository.findAll();
	}
	
	@Override
	public Optional<Factura> getFactura(String id) {
		return iFacturaRepository.findById(id);
	}
	
	@Override
	public void deleteFactura(Factura factura) {
		System.out.println("factura=>"+factura.getNombre());
		iFacturaRepository.delete(factura);
	}

}
