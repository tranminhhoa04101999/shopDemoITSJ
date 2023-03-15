package com.example.shopdemoitsj.repository;

import com.example.shopdemoitsj.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
