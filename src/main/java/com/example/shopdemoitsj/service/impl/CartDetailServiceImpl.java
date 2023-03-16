package com.example.shopdemoitsj.service.impl;

import com.example.shopdemoitsj.dto.AddToCartDto;
import com.example.shopdemoitsj.model.Cart;
import com.example.shopdemoitsj.model.CartDetail;
import com.example.shopdemoitsj.model.Customer;
import com.example.shopdemoitsj.model.Item;
import com.example.shopdemoitsj.repository.CartDetailRepository;
import com.example.shopdemoitsj.repository.CartRepository;
import com.example.shopdemoitsj.repository.CustomerRepository;
import com.example.shopdemoitsj.repository.ItemRepository;
import com.example.shopdemoitsj.service.CartDetailService;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * service chi tiet gio hang.
 * */
@Service
public class CartDetailServiceImpl implements CartDetailService {
  @Autowired private CartDetailRepository cartDetailRepository;
  @Autowired private CartRepository cartRepository;
  @Autowired private CustomerRepository customerRepository;
  @Autowired private ItemRepository itemRepository;

  @Override
  public void add(AddToCartDto addToCartDto) {
    Customer customer;
    Optional<Customer> customerOptional = customerRepository.findById(addToCartDto.getCustomerId());
    customer = customerOptional.orElseGet(Customer::new);

    Cart cart = cartRepository.findByCustomerId(customer.getId());
    Item item;
    Optional<Item> itemOpt = itemRepository.findById(addToCartDto.getItemId());
    item = itemOpt.orElseGet(Item::new);

    CartDetail cartDetail = new CartDetail();

    cartDetail.setId(0);
    cartDetail.setCart(cart);
    cartDetail.setItem(item);
    cartDetail.setQuantity(addToCartDto.getQuantity());
    cartDetail.setDateAdded(new Date());

    cartDetailRepository.save(cartDetail);
  }
}
