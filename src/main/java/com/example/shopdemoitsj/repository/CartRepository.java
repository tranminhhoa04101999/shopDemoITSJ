package com.example.shopdemoitsj.repository;

import com.example.shopdemoitsj.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * jpa.
 * */
public interface CartRepository extends JpaRepository<Cart, Integer> {
  Cart findByCustomerId(int customerId);
}
