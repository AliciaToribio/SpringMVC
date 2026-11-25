package com.companyname.springapp.business.repositories;

import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.companyname.springapp.business.SpringappBusinessConfig;
import com.companyname.springapp.business.entities.Product;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringappBusinessConfig.class})
public class ProductRepositoryTests {
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testGetProductList() {
        List<Product> products = (List<Product>) productRepository.findAll();
        assertEquals(products.size(), 3, 0);
    }

    @Test
    public void testSaveProduct() {
        List<Product> products = (List<Product>) productRepository.findAll();

        Product p = products.get(0);
        Double price = p.getPrice();
        p.setPrice(200.12);
        productRepository.save(p);

        List<Product> updatedProducts = (List<Product>) productRepository.findAll();
        Product p2 = updatedProducts.get(0);
        assertEquals(p2.getPrice(), 200.12, 0);

        p2.setPrice(price);
        productRepository.save(p2);
    }
}
