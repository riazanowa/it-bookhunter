package ru.ryazanova.itbookstore.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.ryazanova.itbookstore.entity.Customer;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class CustomerRepositoryTests {

    @Autowired
    private CustomerRepository customerRepository;

    private Customer customer;

    @BeforeEach
    public void setup() {
        customer = new Customer();
        customer.setFirstName("Vasya");
        customer.setLastName("Pupkin");
        customer.setId(1);
        customer.setEmail("pupkin@gamil.com");
        customer.setOrders(Collections.EMPTY_SET);
    }

    // JUnit test for save customer operation
    @Test
    public void givenEmployeeObject_whenSave_thenSavedEmployee() {

        // when - action
        Customer savedCustomer = customerRepository.save(customer);

        // then
        Assertions.assertThat(savedCustomer).isNotNull();
        Assertions.assertThat(savedCustomer).isEqualTo(customer);
    }

    @Test
    public void givenCustomerList_whenFindAll_thenReturnCustomerList() {
        Customer customer2 = new Customer();
        customer2.setFirstName("Maria");
        customer2.setLastName("Petrova");
        customer2.setId(2);
        customer2.setEmail("petrova@gamil.com");
        customer2.setOrders(Collections.EMPTY_SET);

        customerRepository.save(customer);
        customerRepository.save(customer2);

        // when
        List<Customer> customerList = customerRepository.findAll();

        // then
        Assertions.assertThat(customerList).isNotNull();
        Assertions.assertThat(customerList.size()).isEqualTo(2);
    }


    @Test
    public void givenExistentCustomerEmail_whenFindByEmail_thenReturnEmployee() {

        customerRepository.save(customer);

        Customer customerFromDB = customerRepository.findByEmail(customer.getEmail());

        Assertions.assertThat(customerFromDB).isNotNull();
        Assertions.assertThat(customer.getEmail()).isEqualTo(customerFromDB.getEmail());

    }

    @Test
    public void givenCustomer_whenDelete_thenRemoveCustomer(){

        customerRepository.save(customer);

        // when -  action or the behaviour that we are going test
        customerRepository.deleteById(customer.getId());
        Optional<Customer> customerOptional = customerRepository.findById(customer.getId());

        // then - verify the output
        Assertions.assertThat(customerOptional).isEmpty();
    }
}
