package com.example.shopdemoitsj.repository;

import com.example.shopdemoitsj.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * jpa.
 * */
public interface ItemRepository extends JpaRepository<Item, Integer> {}
