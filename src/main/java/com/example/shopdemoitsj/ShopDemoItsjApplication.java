package com.example.shopdemoitsj;

import com.example.shopdemoitsj.dto.CustomerDto;
import com.example.shopdemoitsj.mapper.CustomerMapper;
import com.example.shopdemoitsj.model.Cart;
import com.example.shopdemoitsj.model.Customer;
import com.example.shopdemoitsj.repository.CartRepository;
import com.example.shopdemoitsj.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;



/**
 * main.
 */
@SpringBootApplication
public class ShopDemoItsjApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ShopDemoItsjApplication.class, args);
    }



    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CartRepository cartRepository;

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
        Customer customer = customerRepository.save(CustomerMapper.getInstance().toEntity(customerDto));
        Cart cart = new Cart(0, customer);
        Cart cartSave = cartRepository.save(cart);
        System.out.println(cartSave);
        System.out.println(customer);
        // khoi tao admin
        CustomerDto customerDto2 = new CustomerDto();
        customerDto2.setId(0);
        customerDto2.setPassword(passwordEncoder.encode("123"));
        customerDto2.setUsername("admin");
        customerDto2.setType(0);
        Customer customer2 = customerRepository.save(CustomerMapper.getInstance().toEntity(customerDto2));
        System.out.println(customer2);

    }
}
