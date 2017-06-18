package com.backbase.spring.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.backbase.spring.model.Atm;
import com.backbase.spring.service.ResponseServiceImpl;

/**
 * This controller is responsible to handle exclusive RESTfull calls
 * @author wpjunior
 *
 */
@RestController
public class ResponseRestController extends AbstractUserController{

	private static final Logger log = Logger.getLogger(ResponseRestController.class);
	
	@Autowired
	private ResponseServiceImpl responseService;

	
	@GetMapping("/list")
	public List<Atm> getList() {
		
		log.info("User="+ getPrincipal()+", searching all ATMs!");
		
		return responseService.getATMs();
		
	}

	@GetMapping("/search/city/{city}")
	public List<Atm> getSearch(@PathVariable("city") String city) {

		log.info("User="+ getPrincipal()+", searching ATM by city="+city);
		
		List<Atm> list = responseService.getATMsByCity(city);
		
		return list;
	}

}