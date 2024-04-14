package com.manjari.productservicesst.repositories;

import org.springframework.stereotype.Repository;

import com.manjari.productservicesst.models.Product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
      @Override
      Optional<Product> findById(Long id);
      @Override
       Product save(Product product);

}
