package com.example.shopdemoitsj.repository;

import com.example.shopdemoitsj.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * jpa.
 * */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
    List<OrderDetail> findByOrdersId (int id);


}
