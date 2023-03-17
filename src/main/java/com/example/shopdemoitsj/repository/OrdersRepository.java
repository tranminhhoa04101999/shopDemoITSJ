package com.example.shopdemoitsj.repository;



import com.example.shopdemoitsj.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * jpa.
 * */
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

}
