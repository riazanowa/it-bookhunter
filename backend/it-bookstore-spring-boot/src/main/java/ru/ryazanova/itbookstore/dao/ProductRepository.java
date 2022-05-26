package ru.ryazanova.itbookstore.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ryazanova.itbookstore.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

   /* Spring exposes automatically the endpoint
    http://localhost:8080/api/products/search/findByCategoryId?id=2
    */
    Page<Product> findByCategoryId(@RequestParam("id") Integer id, Pageable pageable);

//    for search component
//    Spring exposes automatically the endpoint
//    http://localhost:8080/api/products/search/findByNameContaining?name=Python
    Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
}
