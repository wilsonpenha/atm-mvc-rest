package com.backbase.sping.test;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.backbase.spring.model.Atm;
import com.backbase.spring.service.ResponseServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Simple Junit test to call ResponseServiceImpl.getATMsByCity() method to retrieve a valid city "Amsterdam"
 * @author wpjunior
 *
 */
@Configuration
@ComponentScan("com.backbase.spring.service")
public class ResponseServiceTest {

	@Autowired
	private ResponseServiceImpl responseService = new ResponseServiceImpl();
	
	@Test
	public void testInvalidJson() throws JsonProcessingException, IOException {
		List<Atm> atmList = responseService.getATMsByCity("Amsterdam");

		
		Assert.assertEquals(true, atmList.get(0).getAddress().getCity().equalsIgnoreCase("Amsterdam"));

	}
}
