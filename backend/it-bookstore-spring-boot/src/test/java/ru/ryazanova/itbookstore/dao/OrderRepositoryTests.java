package ru.ryazanova.itbookstore.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Pageable;
import ru.ryazanova.itbookstore.entity.Address;
import ru.ryazanova.itbookstore.entity.Customer;
import ru.ryazanova.itbookstore.entity.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;

@DataJpaTest
public class OrderRepositoryTests {

    @Autowired
    private OrderRepository orderRepository;

    private Customer customer;

    private Order order;

    @BeforeEach
    public void setup() {
        customer = new Customer();
        customer.setFirstName("Vasya");
        customer.setLastName("Pupkin");
        customer.setId(1);
        customer.setEmail("pupkin@gamil.com");
        customer.setOrders(Collections.EMPTY_SET);

        order = new Order();
        order.setId(1);
        order.setCustomer(customer);
        order.setShippingAddress(new Address());
        order.setDateCreated(LocalDateTime.now());
        order.setStatus("OK");
        order.setTotalPrice(BigDecimal.valueOf(17.22));
        order.setBillingAddress(new Address());
        order.setOrderTrackingNumber("gfhjslfpffjekekbhsj");
        order.setTotalQuantity(1);
        order.setOrderItems(Collections.EMPTY_SET);
    }

    @Test
    public void givenExistentCustomerEmail_whenfindByCustomerEmailOrder_thenReturnOrder() {

        orderRepository.save(order);

       // Order orderFromDB = orderRepository.findByCustomerEmailOrderByDateCreatedDesc(customer.getEmail(), );

       // Assertions.assertThat(orderFromDB).isNotNull();

    }
}
