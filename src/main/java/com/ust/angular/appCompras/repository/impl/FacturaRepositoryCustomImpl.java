package com.ust.angular.appCompras.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.client.result.UpdateResult;
import com.ust.angular.appCompras.repository.IFacturaRepositoryCustom;
import com.ust.angular.appCompras.resources.Factura;

@Repository
public class FacturaRepositoryCustomImpl implements IFacturaRepositoryCustom {
	
	MongoTemplate mongoTemplate;
	
	@Autowired
	public void facturaRepositoryCustomImpl(MongoTemplate mongoTemp) {
		this.mongoTemplate = mongoTemp;
	}
	
	@Override
	public Factura getMaxFactId() {
		//Query query = new Query(Criteria.where("nombre").is("Telefonica"));
		Query query = new Query();
		query.with(new Sort(Sort.Direction.DESC, "id"));
		query.limit(1);
		return mongoTemplate.findOne(query, Factura.class);
		
		/*
		if(factura == null) {
			return 0L;
		}
		
		return factura.getId();*/
	}
	
	@Override
    public long updateFactura(String nombre, String proveedor) {
        Query query = new Query(Criteria.where("nombre").is(nombre));
        Update update = new Update();
        update.set("proveedor", proveedor);
 
        UpdateResult result = this.mongoTemplate.updateFirst(query, update, Factura.class);
        
        //List<Factura> facturaResponse = mongoTemplate.find(query, Factura.class);
        
        if (result != null) {
            return 0;
        }
 
        return 1;
    }
	
}
