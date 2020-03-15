package com.sat.rest.controller;

import java.io.UnsupportedEncodingException;
import java.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.sat.rest.model.BloodBank;
import com.sat.rest.service.ConsumerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Api(value = "Consumer Controller")
public class ConsumerController {

  @Autowired
  ConsumerService consumerService;

  @ApiOperation(value = "returns list of near earth objects between specified dates")
  @ApiResponses(value = {@ApiResponse(code = 100, message = "100 is some message")})
  @GetMapping(value = "/hello")
  public ResponseEntity<String> getHello() {
    return new ResponseEntity<String>(consumerService.getHello(), HttpStatus.OK);
  }

  @GetMapping(value = "/BloodBank/name/{bloodBankName}")
  public ResponseEntity<BloodBank> getBloodBank(@PathVariable("bloodBankName") String bloodBankName)
      throws UnsupportedEncodingException {
    return new ResponseEntity<BloodBank>(consumerService.getBloodBank(bloodBankName),
        HttpStatus.OK);
  }

  @GetMapping(value = "/BloodBank/city/{city}")
  public ResponseEntity<BloodBank[]> getBloodBankByCity(@PathVariable("city") String city)
      throws UnsupportedEncodingException {
    return new ResponseEntity<BloodBank[]>(consumerService.getBloodBankByCity(city), HttpStatus.OK);
  }

  @GetMapping(value = "/BloodBank/add")
  public void addBloodBank(BloodBank bloodBank) {
    try {
      consumerService.addBloodBank(bloodBank);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BloodBank Already Exists");
    }
  }

  // flux and mono
  @GetMapping(value = "/Mono/BloodBank/name/{bloodBankName}",
      produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
  public Mono<BloodBank> getBloodBankMono(@PathVariable("bloodBankName") String bloodBankName)
      throws UnsupportedEncodingException {

    BloodBank bb = consumerService.getBloodBank(bloodBankName);
    return Mono.just(bb);

  }
  
  @GetMapping(value = "/Flux/BloodBank/city/{city}",
      produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
  public Flux<BloodBank> getBloodBankByCityFlux(@PathVariable("city") String city)
      throws UnsupportedEncodingException {
    
    BloodBank[] bbArr = consumerService.getBloodBankByCity(city); 
    return Flux.fromArray(bbArr).delayElements(Duration.ofSeconds(1));
    
  }

}
