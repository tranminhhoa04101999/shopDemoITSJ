package com.example.shopdemoitsj.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO implements Serializable {

    private int id;
    private String name;
    private double price;
}
