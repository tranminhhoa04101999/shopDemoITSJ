package com.example.shopdemoitsj.repository;

import com.example.shopdemoitsj.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    Cart findByCustomer_Id(int customerId);
}
