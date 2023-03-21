package com.example.shopdemoitsj.repository;

import com.example.shopdemoitsj.model.CartDetail;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/** jpa. */
public interface CartDetailRepository extends JpaRepository<CartDetail, Integer> {
  List<CartDetail> findByCartId(int cartId);

  List<CartDetail> findByItemId(int itemId);

  CartDetail findByCartIdAndItemId(int cartId, int itemId);
}
