package com.geekbrains.geekmarket.repositories;

import com.geekbrains.geekmarket.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    @Query(value="select * from products order by price asc limit 1", nativeQuery = true)
    List<Product> getMinPriceProducts();

    @Query(value="select * from products order by price desc limit 1", nativeQuery = true)
    List<Product> getMaxPriceProducts();

    @Query(value ="select * from products where price in (select min(price) " +
            "from products) union select * from products where price " +
            "in (select max(price) from products);", nativeQuery = true)
    List<Product> getMinAndMaxPriceProducts();
}
