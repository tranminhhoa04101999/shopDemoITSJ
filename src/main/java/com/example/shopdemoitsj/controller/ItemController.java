package com.example.shopdemoitsj.controller;


import com.example.shopdemoitsj.model.Item;
import com.example.shopdemoitsj.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemController {
    @Autowired
    private ItemService itemService;

//    @GetMapping("/items")
//    public ResponseEntity<Item> getItems(){
//        return new ResponseEntity<>(itemService.getItems(), HttpStatus.OK);
//    }


}
