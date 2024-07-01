package org.springtransactional.lesson1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springtransactional.lesson1.entity.Product;
import org.springtransactional.lesson1.repository.ProductRepository;

@Service("productService")
public class ProductService {
    ProductRepository productRepository;

    @Autowired
    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveProductInfo() throws Exception {
        //create a product

        Product product = new Product();
        for (int i = 1; i <= 10; i++) {
            product.setId(i);
            product.setName("Product " + i);
            productRepository.saveProduct(product);
            if(i == 7){
                throw  new Exception("Error occurred");
            }
        }
    }
}
