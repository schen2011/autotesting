package com.lmig.uscm.cl.predictivemodel.client;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestCaseRepository extends MongoRepository<TestCase, String> {
	
    public List<TestCase> findTestCasesByFileName(String filename);

}
