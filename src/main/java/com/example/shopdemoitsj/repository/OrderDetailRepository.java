package com.example.shopdemoitsj.repository;

import com.example.shopdemoitsj.model.OrderDetail;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/** jpa. */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
  List<OrderDetail> findByOrdersId(int id);

  List<OrderDetail> findByItemId(int itemId);
}
