package com.example.shopdemoitsj.controller;


import com.example.shopdemoitsj.dto.ItemDTO;
import com.example.shopdemoitsj.exception.ItemNotFoundException;
import com.example.shopdemoitsj.service.impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemController {
    @Autowired
    private ItemServiceImpl itemServiceImpl;

    @GetMapping("/items")
    public ResponseEntity<List<ItemDTO>> getItems(){
        return new ResponseEntity<>(itemServiceImpl.findAll(), HttpStatus.OK);
    }
    @GetMapping("/items/{itemId}")
    public ResponseEntity<ItemDTO> getItemById(@PathVariable int itemId) throws ItemNotFoundException {
        return new ResponseEntity<>(itemServiceImpl.findById(itemId),HttpStatus.OK);
    }
    /// save item coi lai id
    @PostMapping("/items")
    public ResponseEntity save(@RequestBody ItemDTO itemDTO){
        itemServiceImpl.save(itemDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @PutMapping("/items")
    public ResponseEntity update(@RequestBody ItemDTO itemDTO){
        itemServiceImpl.save(itemDTO);
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/items/{itemId}")
    public ResponseEntity delete(@PathVariable int itemId){
        itemServiceImpl.delete(itemId);
        return new ResponseEntity(HttpStatus.OK);
    }



}






















