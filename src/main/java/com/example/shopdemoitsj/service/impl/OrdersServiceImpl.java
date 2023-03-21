package com.example.shopdemoitsj.service.impl;

import com.example.shopdemoitsj.dto.CartDto;
import com.example.shopdemoitsj.dto.OrdersDto;
import com.example.shopdemoitsj.exception.EmptyCartException;
import com.example.shopdemoitsj.exception.OrderFalse;
import com.example.shopdemoitsj.exception.OrdersNotFoundException;
import com.example.shopdemoitsj.mapper.CartDetailMapper;
import com.example.shopdemoitsj.mapper.CartMapper;
import com.example.shopdemoitsj.mapper.OrdersMapper;
import com.example.shopdemoitsj.model.Cart;
import com.example.shopdemoitsj.model.CartDetail;
import com.example.shopdemoitsj.model.OrderDetail;
import com.example.shopdemoitsj.model.Orders;
import com.example.shopdemoitsj.repository.OrderDetailRepository;
import com.example.shopdemoitsj.repository.OrdersRepository;
import com.example.shopdemoitsj.service.OrdersService;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** service. */
@Service
public class OrdersServiceImpl implements OrdersService {
  @Autowired OrdersRepository ordersRepository;

  @Autowired OrderDetailRepository orderDetailRepository;

  @Override
  public OrdersDto saveOrder(OrdersDto ordersDto) {
    Orders orders = OrdersMapper.getInstance().toEntity(ordersDto);
    return OrdersMapper.getInstance().toDto(ordersRepository.save(orders));
  }

  @Override
  public void placeAnOrder(CartDto cartDto) throws OrderFalse, EmptyCartException {
    if (cartDto.getCartDetailDtos().isEmpty()) {
      throw new EmptyCartException();
    }

    try {
      Cart cart = CartMapper.getInstance().toEntity(cartDto);
      // throw exception khi gio hang trong
      //
      List<CartDetail> cartDetailList =
          cartDto.getCartDetailDtos().stream()
              .map(
                  temp -> {
                    temp.setCartDto(cartDto);
                    return CartDetailMapper.getInstance().toEntity(temp);
                  })
              .collect(Collectors.toList());
      // save order
      Orders orders = new Orders(0, cart.getCustomer(), new Date());
      Orders saveOrders = ordersRepository.save(orders);
      // save order details
      for (int i = 0; i < cartDetailList.size(); i++) {
        OrderDetail orderDetail =
            new OrderDetail(
                0,
                saveOrders,
                cartDetailList.get(i).getItem(),
                cartDetailList.get(i).getQuantity());
        orderDetailRepository.save(orderDetail);
      }
    } catch (Exception ex) {
      throw new OrderFalse();
    }
  }

  @Override
  public OrdersDto findById(int id) throws OrdersNotFoundException {
    Orders orders;
    Optional<Orders> ordersOptional = ordersRepository.findById(id);
    orders = ordersOptional.orElseGet(Orders::new);

    if (ordersOptional.isPresent()) {
      return OrdersMapper.getInstance().toDto(orders);
    } else {
      throw new OrdersNotFoundException();
    }
  }

  @Override
  public void delete(int id) {
    ordersRepository.deleteById(id);
  }

  @Override
  public List<OrdersDto> findByCustomerId(int customerId) {
    List<Orders> ordersList = ordersRepository.findByCustomerId(customerId);

    return ordersList.stream()
        .map(temp -> OrdersMapper.getInstance().toDto(temp))
        .collect(Collectors.toList());
  }

  @Override
  public OrdersDto findByCustomerIdAndMaxOrderId(int customerId) {
    return OrdersMapper.getInstance()
        .toDto(ordersRepository.findByCustomerIdAndMaxOrderId(customerId));
  }
}
