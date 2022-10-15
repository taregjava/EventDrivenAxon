package com.halfacode.ProductService.command.api.events;

import com.halfacode.ProductService.command.api.entity.Product;
import com.halfacode.ProductService.command.api.entity.ProductRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductEventsHandler {

    private ProductRepository productRepository;

    public ProductEventsHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventHandler
    public void on(ProductCreateEvent productCreateEvent){

        Product product=
                new Product();
        BeanUtils.copyProperties(productCreateEvent,product);
        productRepository.save(product);
    }
}
