package com.capg.fms.addflights.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.capg.fms.addflights.model.Flight;
import com.capg.fms.addflights.service.AddFlightServiceImpl;


@RestController
@RequestMapping("/api")
public class AddFlightController {

	@Autowired
	AddFlightServiceImpl  addflightService;
	
	@GetMapping("/all")
	public List<Flight>  findAll()
	{
		  return addflightService.findAll();
	}

//	@GetMapping("/flight/id/{id}")
//	public Flight getOne(@PathVariable int id) 
//	{
//		  return AddFlightServiceImpl.getOne(id);
//	}
	
	@PostMapping("/add")
	public Flight  save(@RequestBody Flight flight)
	{
		return  AddFlightServiceImpl.save(flight);
	}
	
//	@DeleteMapping("/flight/id/{id}")
//	public boolean  deleteById(@PathVariable int id)
//	{
//		return  AddFlightServiceImpl.deleteById(id);
//	}

//	@PutMapping("/flight")
//	public Flight  updateFlight(@RequestBody Flight flight)
//	{
//		return  AddFlightServiceImpl.updateProduct(flight);
//	}
	


}
