package io.javaexpert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javaexpert.service.PolicyService;

@RestController
public class PolicyController {

	public static final String URL = "/policy/{policyNumber}";
	
	@Autowired
	private PolicyService policyService;
	
	@RequestMapping(URL)
	public String getPolicy(@PathVariable final int policyNumber){
	  return policyService.getPolicy(policyNumber);	
	}

}
