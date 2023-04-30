package com.demo.plex.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.plex.request.AveragePriceRequest;
import com.demo.plex.service.TransactionService;

@RestController
public class Controller {

	@Autowired
	TransactionService transactionService;

	@GetMapping(value = "/avgprice")
	public ResponseEntity<Double> getAveragePrice(@RequestBody @Valid AveragePriceRequest request) {
		return new ResponseEntity<>(transactionService.getAveragePrice(request.getToken()), HttpStatus.OK);
	}
	
	@GetMapping(value = "/volume")
	public ResponseEntity<String> getTotalVolume() {
		return new ResponseEntity<>(String.valueOf(transactionService.getTotalVoulme()), HttpStatus.OK);
	}
}
