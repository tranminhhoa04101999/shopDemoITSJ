package com.example.shopdemoitsj.controller;

import com.example.shopdemoitsj.dto.CustomerDto;
import com.example.shopdemoitsj.exception.CustomerNotFoundException;
import com.example.shopdemoitsj.jwt.CustomUserDetails;
import com.example.shopdemoitsj.jwt.JwtTokenProvider;
import com.example.shopdemoitsj.model.Customer;
import com.example.shopdemoitsj.service.impl.CustomerServiceImpl;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** người mua hàng controller. */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class CustomerController {
  @Autowired private CustomerServiceImpl customerServiceImpl;

  @Autowired AuthenticationManager authenticationManager;

  @Autowired private JwtTokenProvider tokenProvider;

  @PostMapping("/login")
  public String authenticaLogin(@Valid @RequestBody Customer customer) {

    // Xác thực từ username và password.
    Authentication authentication =
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                customer.getUsername(), customer.getPassword()));
    // Nếu không xảy ra exception tức là thông tin hợp lệ
    // Set thông tin authentication vào Security Context
    SecurityContextHolder.getContext().setAuthentication(authentication);

    // Trả về jwt cho người dùng.
    return tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
  }

  @GetMapping("/customers")
  @PreAuthorize("hasRole('ROLE_USER')")
  public ResponseEntity<List<CustomerDto>> findAll() {
    return new ResponseEntity<>(customerServiceImpl.findAll(), HttpStatus.OK);
  }

  @GetMapping("/customers/{customerId}")
  public ResponseEntity<CustomerDto> findById(@PathVariable int customerId)
      throws CustomerNotFoundException {
    return new ResponseEntity<>(customerServiceImpl.findById(customerId), HttpStatus.OK);
  }

  @PostMapping("/customers")
  public ResponseEntity<CustomerDto> save(@RequestBody CustomerDto customerDto) {
    return new ResponseEntity<>(customerServiceImpl.save(customerDto),HttpStatus.CREATED);
  }

  @GetMapping("/customers/username/{username}")
  public ResponseEntity<CustomerDto> findByUsername(@PathVariable String username) {
    return new ResponseEntity<>(customerServiceImpl.findByUserName(username), HttpStatus.OK);
  }


}
