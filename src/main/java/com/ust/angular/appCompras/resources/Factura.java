package com.ust.angular.appCompras.resources;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Factura {
	
	@Id
	private String id; // The id is mostly for internal use by MongoDB
	
	@Indexed
	private String nombre;
	private float precio;
	private String iva;
	private String proveedor;
	
	public Factura(String id, String nombre, float precio, String iva, String proveedor) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.iva = iva;
		this.proveedor = proveedor;
	}
	
	public Factura() {
		
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}


	public float getPrecio() {
		return precio;
	}


	public String getIva() {
		return iva;
	}


	public String getProveedor() {
		return proveedor;
	}

	
}
