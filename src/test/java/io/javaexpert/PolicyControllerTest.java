package io.javaexpert;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import io.javaexpert.controller.PolicyController;
import io.javaexpert.service.PolicyService;

@RunWith(SpringRunner.class)
@WebMvcTest(PolicyController.class)
public class PolicyControllerTest {
  private final int policyNumber=5;
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private PolicyService policyService;
	
	@Test
	public void test() throws Exception{
		
		when(policyService.getPolicy(policyNumber)).thenReturn("vinod");
		
		mvc.perform(get(PolicyController.URL,policyNumber).accept(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().isOk()).andExpect(content().string("vinod"));
		
		verify(policyService,times(1)).getPolicy(policyNumber);
	}
}
