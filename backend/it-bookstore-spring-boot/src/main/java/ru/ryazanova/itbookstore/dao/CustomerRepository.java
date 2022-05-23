package ru.ryazanova.itbookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ryazanova.itbookstore.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
