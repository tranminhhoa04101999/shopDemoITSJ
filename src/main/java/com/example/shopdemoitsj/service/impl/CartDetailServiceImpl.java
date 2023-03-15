package com.example.shopdemoitsj.service.impl;

import com.example.shopdemoitsj.dto.AddToCartDTO;
import com.example.shopdemoitsj.model.Cart;
import com.example.shopdemoitsj.model.CartDetail;
import com.example.shopdemoitsj.model.Customer;
import com.example.shopdemoitsj.model.Item;
import com.example.shopdemoitsj.repository.CartDetailRepository;
import com.example.shopdemoitsj.repository.CartRepository;
import com.example.shopdemoitsj.repository.CustomerRepository;
import com.example.shopdemoitsj.repository.ItemRepository;
import com.example.shopdemoitsj.service.CartDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CartDetailServiceImpl implements CartDetailService {
    @Autowired
    private CartDetailRepository cartDetailRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public void add(AddToCartDTO addToCartDTO){
        Customer customer = customerRepository.findById(addToCartDTO.getCustomerId()).get();
        Cart cart = cartRepository.findByCustomer_Id(customer.getId());
        Item item = itemRepository.findById(addToCartDTO.getItemId()).get();
        CartDetail cartDetail = new CartDetail();

        cartDetail.setId(0);
        cartDetail.setCart(cart);
        cartDetail.setItem(item);
        cartDetail.setQuantity(addToCartDTO.getQuantity());
        cartDetail.setDateAdded(new Date());

        cartDetailRepository.save(cartDetail);
    }
}
