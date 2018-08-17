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
	@PostMapping("/bill/add")
	public ResponseEntity<Factura> addFacturas(@RequestBody Factura factura) {
		return ResponseEntity.ok(iFacturaService.saveFactura(factura));
	}
	
	@CrossOrigin()
	@ApiOperation(value = "list bill resource", response = Factura.class, nickname = "resumeListBill", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE, tags= {"factura"})
	@ApiResponses({ @ApiResponse(code = 201, message = "list bill resource") })
	@GetMapping("/bill/list")
	public ResponseEntity<List<Factura>> getFacturas() {
		return ResponseEntity.ok(iFacturaService.getFacturas());
	}
	
	@CrossOrigin()
	@ApiOperation(value = "bill resource", response = Factura.class, nickname = "resumeBill", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE, tags= {"factura"})
	@ApiResponses({ @ApiResponse(code = 201, message = "bill resource") })
	@GetMapping("/bill/{id}")
	public ResponseEntity<Optional<Factura>> getFactura(@ApiParam(value="ID bill to delete") @PathVariable(required=true) final String id) {
		return ResponseEntity.ok(iFacturaService.getFactura(id));
	}
	
	@CrossOrigin()
	@ApiOperation(value = "delete a bill resource", response = Factura.class, nickname = "resumeBill", httpMethod = "DELETE", produces = MediaType.APPLICATION_JSON_VALUE, tags= {"factura"})
	@ApiResponses({ @ApiResponse(code = 201, message = "delete a bill resource") })
	@DeleteMapping("/bill/{id}")
	public void deleteFactura(@ApiParam(value="ID bill to delete") @PathVariable(required=true) final String id) {
		iFacturaService.deleteFactura(id);
	}
	
	

}
