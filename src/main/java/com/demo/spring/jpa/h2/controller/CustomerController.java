package com.demo.spring.jpa.h2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.jpa.h2.model.Customer;
import com.demo.spring.jpa.h2.repository.CustomerRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	CustomerRepository CustomerRepository;

	@GetMapping("/Customers")
	public ResponseEntity<List<Customer>> getAllCustomers(@RequestParam(required = false) String title) {
		try {
			List<Customer> Customers = new ArrayList<Customer>();

		
				CustomerRepository.findAll().forEach(Customers::add);

			if (Customers.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(Customers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/Customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long id) {
		Optional<Customer> CustomerData = CustomerRepository.findById(id);

		if (CustomerData.isPresent()) {
			return new ResponseEntity<>(CustomerData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/Customers")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer Customer) {
		try {
			Customer _Customer = CustomerRepository
					.save(new Customer(Customer.getTifID(),Customer.getCustomerID(),Customer.getAppRefID(),Customer.getCustomerName(),Customer.getMobile(),Customer.getLoanAmt(),Customer.getAddress()));
			return new ResponseEntity<>(_Customer, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/Customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer Customer) {
		Optional<Customer> CustomerData = CustomerRepository.findById(id);

		if (CustomerData.isPresent()) {
			Customer _Customer = CustomerData.get();
			_Customer.setCustomerID(Customer.getCustomerID());
			_Customer.setAppRefID(Customer.getAppRefID());
			_Customer.setCustomerName(Customer.getCustomerName());
			_Customer.setMobile(Customer.getMobile());
			_Customer.setLoanAmt(Customer.getLoanAmt());
			_Customer.setAddress(Customer.getAddress());
			
			return new ResponseEntity<>(CustomerRepository.save(_Customer), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/Customers/{id}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") long id) {
		try {
			CustomerRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/Customers")
	public ResponseEntity<HttpStatus> deleteAllCustomers() {
		try {
			CustomerRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
