package com.example.shopdemoitsj.repository;

import com.example.shopdemoitsj.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * jpa.
 * */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

}
