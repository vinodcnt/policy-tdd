package io.javaexpert.service;

import org.springframework.stereotype.Service;

@Service
public class PolicyService {
	public String getPolicy(int policyNumber) {
		return policyNumber > 5 ? "vinod" : "chemmengatt";
	}
}
