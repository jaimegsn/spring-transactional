package org.springtransactional.lesson1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springtransactional.lesson1.entity.Product;

@Repository
public class ProductRepository {

    JdbcTemplate jdbcTemplate;

    @Autowired
    ProductRepository (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveProduct(Product product){
        String sql = "INSERT INTO PRODUCT VALUES (?,?)";
        jdbcTemplate.update(sql, product.getId(), product.getName());
        System.out.println("a row is saved in db");
    }
}
