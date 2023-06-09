package com.example.shopdemoitsj.service.impl;

import com.example.shopdemoitsj.dto.AddToCartDto;
import com.example.shopdemoitsj.dto.CartDetailDto;
import com.example.shopdemoitsj.exception.QuantityLessThanOneException;
import com.example.shopdemoitsj.mapper.CartDetailMapper;
import com.example.shopdemoitsj.mapper.ItemMapper;
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

/** service chi tiet gio hang. */
@Service
public class CartDetailServiceImpl implements CartDetailService {
  @Autowired private CartDetailRepository cartDetailRepository;
  @Autowired private CartRepository cartRepository;
  @Autowired private CustomerRepository customerRepository;
  @Autowired private ItemRepository itemRepository;

  @Override
  public CartDetailDto add(AddToCartDto addToCartDto) {
    Customer customer;
    Optional<Customer> customerOptional = customerRepository.findById(addToCartDto.getCustomerId());
    customer = customerOptional.orElseGet(Customer::new);

    // kiểm tra coi tbl giỏ hàng được tạo chưa
    Cart cart = cartRepository.findByCustomerId(customer.getId());
    if (cart == null) {
      cartRepository.save(new Cart(0, customer));
      cart = cartRepository.findByCustomerId(customer.getId());
    }

    Item item;
    Optional<Item> itemOpt = itemRepository.findById(addToCartDto.getItemId());
    item = itemOpt.orElseGet(Item::new);

    CartDetail cartDetail = cartDetailRepository.findByCartIdAndItemId(cart.getId(), item.getId());

    // kiem tra item do da co trong gio chua nếu có rồi thì số lượng cộng
    // lấy ra cartdetail theo item id và cart id để check coi item đó có trong giỏ chưa
    //    cartDetail = cartDetailRepository.findByCartIdAndItemId(cart.getId(),item.getId());

    if (cartDetail == null) {
      cartDetail = new CartDetail();
      cartDetail.setId(0);
      cartDetail.setCart(cart);
      cartDetail.setItem(item);
      cartDetail.setQuantity(addToCartDto.getQuantity());
      cartDetail.setDateAdded(new Date());
    } else {
      cartDetail.setQuantity(cartDetail.getQuantity() + addToCartDto.getQuantity());
    }
    //

    return CartDetailMapper.getInstance().toDto(cartDetailRepository.save(cartDetail));
  }

  @Override
  public CartDetailDto update(CartDetailDto cartDetailDto) throws QuantityLessThanOneException {
    Cart cart = new Cart();
    cart.setId(cartDetailDto.getCartDto().getId());

    CartDetail cartDetail = new CartDetail();
    cartDetail.setId(cartDetailDto.getId());
    cartDetail.setCart(cart);
    cartDetail.setItem(ItemMapper.getInstance().toEntity(cartDetailDto.getItemDto()));
    cartDetail.setQuantity(cartDetailDto.getQuantity());
    cartDetail.setDateAdded(cartDetailDto.getDateAdded());

    if (cartDetail.getQuantity() < 1) {
      throw new QuantityLessThanOneException();
    }
    return CartDetailMapper.getInstance().toDto(cartDetailRepository.save(cartDetail));
  }
}
