package com.example.shopdemoitsj.repository;

import com.example.shopdemoitsj.model.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartDetailRepository extends JpaRepository<CartDetail,Integer> {
    List<CartDetail> findByCart_Id(int cartId);
}
