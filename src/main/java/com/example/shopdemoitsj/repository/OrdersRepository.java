package com.example.shopdemoitsj.repository;



import com.example.shopdemoitsj.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * jpa.
 * */
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    List<Orders> findByCustomerId(int customerId);

    @Query("SELECT v FROM Orders v WHERE v.id = (SELECT MAX(u.id) FROM Orders u) and v.id = :customerId")
    Orders findByCustomerIdAndMaxOrderId(@Param("customerId") int customerId);
}
