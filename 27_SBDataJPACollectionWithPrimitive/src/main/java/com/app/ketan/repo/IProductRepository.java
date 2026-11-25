package com.app.ketan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.ketan.entity.Product;

public interface IProductRepository extends JpaRepository<Product, Integer> {

}
