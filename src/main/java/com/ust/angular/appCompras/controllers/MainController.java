package com.ust.angular.appCompras.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.angular.appCompras.resources.Factura;
import com.ust.angular.appCompras.services.IFacturaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
public class MainController {
	
	private IFacturaService iFacturaService;
	
	@Autowired
	private void maincontroller(IFacturaService facturaService) {
		this.iFacturaService = facturaService;
	}
	
	// Enabling Cross-Origin Resource Sharing (CORS) is straightforward – just add the annotation @CrossOrigin.
	@CrossOrigin()
	@ApiOperation(value = "create a bill resource", response = Factura.class, nickname = "createBill", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE, tags= {"factura"})
	@ApiResponses({ @ApiResponse(code = 201, message = "create a bill resource") })
	@PostMapping("/factura")
	public ResponseEntity<Factura> addFacturas(@RequestBody Factura factura) {
		return ResponseEntity.ok(iFacturaService.saveFactura(factura));
	}
	
	@CrossOrigin()
	@ApiOperation(value = "list bill resource", response = Factura.class, nickname = "resumeListBill", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE, tags= {"factura"})
	@ApiResponses({ @ApiResponse(code = 201, message = "list bill resource") })
	@GetMapping("/factura")
	public ResponseEntity<List<Factura>> getFacturas() {
		return ResponseEntity.ok(iFacturaService.getFacturas());
	}
	
	@CrossOrigin()
	@ApiOperation(value = "bill resource", response = Factura.class, nickname = "resumeBill", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE, tags= {"factura"})
	@ApiResponses({ @ApiResponse(code = 201, message = "bill resource") })
	@GetMapping("/factura/{id}")
	public ResponseEntity<Optional<Factura>> getFactura(@ApiParam(value="ID bill to delete") @PathVariable(required=true) final String id) {
		return ResponseEntity.ok(iFacturaService.getFactura(id));
	}
	
	@CrossOrigin()
	@ApiOperation(value = "delete a bill resource", response = Factura.class, nickname = "resumeBill", httpMethod = "DELETE", produces = MediaType.APPLICATION_JSON_VALUE, tags= {"factura"})
	@ApiResponses({ @ApiResponse(code = 201, message = "delete a bill resource") })
	@DeleteMapping("/factura/{id}")
	public void deleteFactura(@ApiParam(value="Id bill to delete") @PathVariable(required=true) final String id) {
		System.out.println("deleteFactura");
		iFacturaService.deleteFactura(id);
	}
	
	@CrossOrigin()
	@ApiOperation(value = "get max bill resource", response = Factura.class, nickname = "getmaxBill", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE, tags= {"factura"})
	@ApiResponses({ @ApiResponse(code = 201, message = "get max bill resource") })
	@GetMapping("/factura/ultima")
	public ResponseEntity<Factura> getMaxFactId() {
		return ResponseEntity.ok(iFacturaService.getMaxFactId());
	}
	
	@CrossOrigin()
	@ApiOperation(value = "update bill resource", response = Factura.class, nickname = "updateBill", httpMethod = "PUT", produces = MediaType.APPLICATION_JSON_VALUE, tags= {"factura"})
	@ApiResponses({ @ApiResponse(code = 201, message = "update bill resource") })
	@PutMapping("/factura/{nombre}/{proveedor}")
	public long updateFactura(@ApiParam(value="Name bill to update") @PathVariable(required=true) final String nombre, 
			@ApiParam(value="Provider bill to update") @PathVariable(required=true) final String proveedor) {
		return iFacturaService.updateFactura(nombre, proveedor);
	}
	
	

}
