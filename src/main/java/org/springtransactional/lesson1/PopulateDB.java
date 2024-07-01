package org.springtransactional.lesson1;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springtransactional.lesson1.config.ProductConfig;
import org.springtransactional.lesson1.service.ProductService;

public class PopulateDB {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ProductConfig.class);
        context.registerShutdownHook();

        ProductService service = context.getBean("productService", ProductService.class);
        service.saveProductInfo();

        context.close();
    }
}
