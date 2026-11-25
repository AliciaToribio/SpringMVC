package com.companyname.springapp.business.services;
import java.util.List;

import com.companyname.springapp.business.entities.Product;
import com.companyname.springapp.business.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleProductManager implements ProductManager{
    @Autowired(required = false)
    private ProductRepository productRepository;

    private List<Product> products;

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public List<Product> getProducts() {
        if (productRepository != null) {
            return (List<Product>) productRepository.findAll();
        }
        return products;
    }

    @Override
    public void increasePrice(int percentage) {
        List<Product> targetProducts = (productRepository != null)
                ? (List<Product>) productRepository.findAll()
                : products;

        if (targetProducts != null) {
            for (Product product : targetProducts) {
                if (product.getPrice() != null) {
                    double newPrice = product.getPrice().doubleValue() * (100 + percentage) / 100.0;
                    product.setPrice(newPrice);
                    if (productRepository != null) {
                        productRepository.save(product);
                    }
                }
            }
        }
    }
}
