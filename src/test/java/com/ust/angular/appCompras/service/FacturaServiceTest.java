package com.ust.angular.appCompras.service;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ust.angular.appCompras.repository.IFacturaRepository;
import com.ust.angular.appCompras.resources.Factura;
import com.ust.angular.appCompras.services.impl.FacturaServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class FacturaServiceTest {
	
	@InjectMocks
	FacturaServiceImpl facturaServiceImpl;
	
	@Mock
	IFacturaRepository ifacturaRepository;
	
	@Test
	public void test() {
		List <Factura> facturasResponse = new ArrayList<>();
		List <Factura> facturas = new ArrayList<>();
		Mockito.when(ifacturaRepository.findAll()).thenReturn(facturasResponse);
		facturas = facturaServiceImpl.getFacturas();
		assertThat(facturas).isNotNull();
	}

}
