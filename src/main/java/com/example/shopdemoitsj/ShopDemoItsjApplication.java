package com.example.shopdemoitsj;

import com.example.shopdemoitsj.dto.CustomerDto;
import com.example.shopdemoitsj.mapper.CustomerMapper;
import com.example.shopdemoitsj.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * main.
 * */
@SpringBootApplication
public class ShopDemoItsjApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(ShopDemoItsjApplication.class, args);
  }

  @Autowired
  CustomerRepository customerRepository;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Override
  public void run(String... args) throws Exception {
    // Khi chương trình chạy
    // Insert vào csdl một user.
    CustomerDto customerDto = new CustomerDto();
    customerDto.setId(0);
    customerDto.setPassword(passwordEncoder.encode("123"));
    customerDto.setUsername("hoa1");
    customerDto.setType(1);
    customerRepository.save(CustomerMapper.getInstance().toEntity(customerDto));
    System.out.println(customerDto);
  }
}
