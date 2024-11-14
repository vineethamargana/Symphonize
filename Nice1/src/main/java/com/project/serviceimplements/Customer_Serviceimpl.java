package com.project.serviceimplements;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.dto.Customer_dto;
import com.project.exception.Mycustomexception;
import com.project.models.Customer_Model;
import com.project.repository.CustomerRepository;
import com.project.service.Customer_Service;

@Service
public class Customer_Serviceimpl implements Customer_Service {

	@Autowired
	private CustomerRepository repo;

	@Override
	public ResponseEntity<Customer_dto> cust_to_dto(Customer_Model customer) {

		Customer_dto dto = new Customer_dto();
		dto.setCid(customer.getCid());
		dto.setCname(customer.getCname());

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Customer_dto> Register(Customer_Model customer) {

		Customer_Model obj = new Customer_Model();
		String cnumber = customer.getCnumber();

		if (cnumber.length() < 10) {
			throw new Mycustomexception("Phone number should contain 10 digits", HttpStatus.EXPECTATION_FAILED);
		}
		String cadharno = customer.getCadharno();

		if (cadharno.length() < 12) {
			throw new Mycustomexception("Adhar number should contain 12 digits", HttpStatus.EXPECTATION_FAILED);
		}

		repo.save(customer);

		return cust_to_dto(customer);
	}

	@Override
	public ResponseEntity<String> Delete(Long cid) {
		if (repo.existsById(cid)) {
			repo.deleteById(cid);
			return new ResponseEntity<>("Customer deleted succesfully", HttpStatus.OK);
		} else {
			throw new Mycustomexception("Customer with " + cid + " is not present", HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public ResponseEntity<Customer_Model> Update(Long cid, Customer_Model model) {

		Optional<Customer_Model> opt = repo.findById(cid);

		if (opt.isPresent()) {
			Customer_Model existingCustomer = opt.get();
			existingCustomer.setCname(model.getCname());
			existingCustomer.setCnumber(model.getCnumber());
			existingCustomer.setCadharno(model.getCadharno());

			Customer_Model updatedCustomer = repo.save(existingCustomer);
			return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
		} else {
			throw new Mycustomexception("Customer with ID " + cid + " not found", HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<Customer_Model> Getcustomer(long cid) {
		Optional<Customer_Model> obj = repo.findById(cid);
//			Customer_Model mod=obj.get();
		if (obj.isPresent()) {
//				Customer_Model obj1=new Customer_Model();
			return new ResponseEntity<>(obj.get(), HttpStatus.OK);
		} else {
			throw new Mycustomexception("Cid is not present", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<List<Customer_Model>> getcustomers() {
		List<Customer_Model> obj = repo.findAll();
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

}
