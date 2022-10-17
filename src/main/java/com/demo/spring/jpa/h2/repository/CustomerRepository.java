package com.demo.spring.jpa.h2.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.spring.jpa.h2.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
