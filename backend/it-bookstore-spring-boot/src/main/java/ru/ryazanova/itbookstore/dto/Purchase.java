package ru.ryazanova.itbookstore.dto;

import lombok.Data;
import ru.ryazanova.itbookstore.entity.Address;
import ru.ryazanova.itbookstore.entity.Customer;
import ru.ryazanova.itbookstore.entity.Order;
import ru.ryazanova.itbookstore.entity.OrderItem;

import java.util.Set;

@Data
public class Purchase {
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
