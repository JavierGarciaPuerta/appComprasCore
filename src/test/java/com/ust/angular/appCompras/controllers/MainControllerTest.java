package com.ust.angular.appCompras.controllers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.ust.angular.appCompras.resources.Factura;
import com.ust.angular.appCompras.services.IFacturaService;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class MainControllerTest {
	
	@InjectMocks
	private MainController mainController;
	
	@Mock
	private IFacturaService iFacturaService;
	
	@Test
	public void addFacturaTest() {
		final Factura factura = new Factura();
		final Factura facturaResponse = new Factura();
		Mockito.when(iFacturaService.saveFactura(factura)).thenReturn(facturaResponse);
		mainController.addFacturas(factura);
	
		assertNotNull(facturaResponse);
	}

}
