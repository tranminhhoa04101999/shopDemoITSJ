package com.example.shopdemoitsj.repository;

import com.example.shopdemoitsj.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * jpa.
 * */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {}
