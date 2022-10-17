package com.demo.spring.jpa.h2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.spring.jpa.h2.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
  //List<Tutorial> findByPublished(boolean published);

  //List<Tutorial> findByTitleContaining(String title);
}
