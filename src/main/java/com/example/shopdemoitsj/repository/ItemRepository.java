package com.example.shopdemoitsj.repository;

import com.example.shopdemoitsj.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
