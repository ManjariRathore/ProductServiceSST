package com.manjari.productservicesst.services;

import com.manjari.productservicesst.exception.ProductNotFoundException;
//import com.manjari.productservicesst.exception.CategoryNotFoundException;
import com.manjari.productservicesst.models.Category;
import com.manjari.productservicesst.models.Product;
import com.manjari.productservicesst.repositories.CategoryRepository;
import com.manjari.productservicesst.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service("selfProductService")
//@Primary
public class SelfProductService implements ProductService{
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getProductById(Long id) {
        Optional<Product>  optionalProduct = productRepository.findById(id);
        if( optionalProduct.isEmpty() )throw  new ProductNotFoundException(id,"Product not found");
        return optionalProduct.get();
    }

    @Override
    public Product[] getAllProducts() {
        return new Product[]{new Product(), new Product()};
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();
        Category savedCat ;
        if(category.getId() == null ){
           savedCat = categoryRepository.save(category);
           product.setCategory((savedCat));
        }
        return productRepository.save(product);
    }

//    @Override
//    public Product createProduct(Product product) {
//        Category category = product.getCategory();
//
//        if (category.getId() == null) { // save the category
//            product.setCategory(categoryRepository.save(category));
//        }
//
//        Product product1 = productRepository.save(product);
//        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());
//
//        if (optionalCategory.isEmpty()) {
//            //The category that is passed in the input product in invalid.
//            throw new CategoryNotFoundException("Invalid category id passed");
//        }
//
//        product1.setCategory(optionalCategory.get());
//        return product1;
//    }

}
