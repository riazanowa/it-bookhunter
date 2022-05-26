package ru.ryazanova.itbookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import ru.ryazanova.itbookstore.entity.Customer;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByEmail(String theEmail);
}
