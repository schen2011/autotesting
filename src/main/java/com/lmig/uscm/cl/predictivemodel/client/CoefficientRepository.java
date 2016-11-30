package com.lmig.uscm.cl.predictivemodel.client;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "coefficients", path = "coefficients")
public interface CoefficientRepository extends MongoRepository<Coefficient, String> {
	
    public Coefficient findByName(@Param("name") String Name);
    
    public void deleteByName(@Param("name") String Name);
    
}
