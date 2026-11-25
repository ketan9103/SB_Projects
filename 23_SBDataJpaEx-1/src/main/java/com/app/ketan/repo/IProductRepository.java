package com.app.ketan.repo;

import org.springframework.data.repository.CrudRepository;

import com.app.ketan.entity.Product;

public interface IProductRepository extends CrudRepository<Product, Integer>{

}
