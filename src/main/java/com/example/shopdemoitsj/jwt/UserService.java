package com.example.shopdemoitsj.jwt;

import com.example.shopdemoitsj.model.Customer;
import com.example.shopdemoitsj.repository.CustomerRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

  @Autowired
  CustomerRepository customerRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Customer customer = customerRepository.findByUsername(username);

    if (customer == null) {
      throw new UsernameNotFoundException(username);
    }
    return new CustomUserDetails(customer);
  }

}
