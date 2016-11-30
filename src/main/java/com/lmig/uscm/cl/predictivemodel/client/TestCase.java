package com.lmig.uscm.cl.predictivemodel.client;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Component
public class TestCase {
	
	private String testcase;
	private CoefficientRaw coeff;
	private String modelType;
	private Date testdate;
	private String fileName;
	

	public Date getTestdate() {
		return testdate;
	}
	public void setTestdate(Date testdate) {
		this.testdate = testdate;
	}

	public String getModelType() {
		return modelType;
	}
	public void setModelType(String modelType) {
		this.modelType = modelType;
	}
	public String getFilename() {
		return fileName;
	}
	public void setFilename(String filename) {
		this.fileName = filename;
	}
	public String getTestcase() {
		return testcase;
	}
	public void setTestcase(String testcase) {
		this.testcase = testcase;
	}
	public CoefficientRaw getCoeff() {
		return coeff;
	}
	public void setCoeff(CoefficientRaw coeff) {
		this.coeff = coeff;
	}
	
	
}
