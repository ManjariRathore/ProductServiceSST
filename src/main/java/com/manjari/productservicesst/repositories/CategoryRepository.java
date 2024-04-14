package com.manjari.productservicesst.repositories;

import com.manjari.productservicesst.models.Category;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Override
    Category save(Category category);
}