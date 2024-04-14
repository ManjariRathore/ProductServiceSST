package com.manjari.productservicesst.services;
import com.manjari.productservicesst.models.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    Product getProductById(Long id);
    Product[] getAllProducts();
    Product createProduct(Product product);

}
