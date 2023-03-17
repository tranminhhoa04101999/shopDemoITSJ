package com.example.shopdemoitsj.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.shopdemoitsj.model.Customer;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CustomerRepositoryTest {
  @Autowired CustomerRepository customerRepository;

  private Customer customerInstance;

  @BeforeEach
  void init() {
    Customer customer = new Customer(1, "username", "password", 0);
    customerInstance = customer;
  }

  @Test
  @DisplayName("JUnit test save customer")
  void whenSave_thenReturnSaveCustomer() {
    Customer result = customerRepository.save(customerInstance);

    assertThat(result).isNotNull();
    assertThat(result.getId()).isPositive();
  }

  @Test
  @DisplayName("JUnit test find all customer")
  void whenFindAll_thenReturnAllCustomer() {

    Customer cus1 = new Customer(1, "name1", "123", 0);
    Customer cus2 = new Customer(2, "name1", "123", 0);
    Customer cus3 = new Customer(3, "name1", "123", 0);

    customerRepository.save(cus1);
    customerRepository.save(cus2);
    customerRepository.save(cus3);

    List<Customer> result = customerRepository.findAll();
    assertThat(result).hasSize(3);
  }

  @Test
  @DisplayName("JUnit test update customer")
  void whenUpdate_thenReturnUpdateCustomer() {
    Customer customer = customerInstance;
    customerRepository.save(customer);

    String newUserName = "hehe";
    customer.setUsername(newUserName);
    customerRepository.save(customer);
    Customer result = customerRepository.findById(customer.getId()).get();

    assertThat(result).isNotNull();
    assertThat(result.getUsername()).isEqualTo(newUserName);
  }

  @Test
  @DisplayName("JUnit test delete customer")
  void whenDelete_thenRemoveCustomer() {
    Customer customer = customerInstance;
    Customer cusTest = customerRepository.save(customer);
    customerRepository.deleteById(cusTest.getId());
    Optional<Customer> result = customerRepository.findById(cusTest.getId());
    assertThat(result).isEmpty();
  }
}
