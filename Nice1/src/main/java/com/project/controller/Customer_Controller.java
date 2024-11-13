package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.Customer_dto;
import com.project.models.Customer_Model;
import com.project.service.Customer_Service;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/Customer")
public class Customer_Controller {
	
	@Autowired
	private Customer_Service service;
	
	@PostMapping("/Register")
	public Customer_dto RegisterUser(@RequestBody Customer_Model customer) {
		return service.Register(customer);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String Deleting(@PathParam(value = "id") Long cid) {
		return service.Delete(cid);
	}
	
	
	@PutMapping("/Update/{cid}")
	public String UpdateUser(@PathParam(value = "cid") Long cid,@RequestBody Customer_Model model) {
		service.Update(cid,model);
		return "Updated succesfully";
	}
	
	
	
}
