package com.coffee.coffee.Repositories;

import com.coffee.coffee.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
