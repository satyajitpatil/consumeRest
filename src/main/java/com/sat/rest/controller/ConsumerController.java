package com.sat.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sat.rest.model.Quote;
import com.sat.rest.service.ConsumerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Consumer Controller")
public class ConsumerController {

	@Autowired
	private ConsumerService consumerService;

	// api address :--------- https://api.nasa.gov/
	@ApiOperation(value = "returns list of near earth objects between specified dates")
	@ApiResponses(value = { @ApiResponse(code = 100, message = "100 is some message") })
	@GetMapping(value = "/sat/neo")
	public ResponseEntity<Quote> getNeo() {
		return new ResponseEntity<Quote>(consumerService.getNeo(), HttpStatus.OK);
	}
	
}
