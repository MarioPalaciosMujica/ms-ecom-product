package com.ecom.product.dalc.repositories;

import com.ecom.product.dalc.entities.ProductTax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductTaxRepository extends JpaRepository<ProductTax, Long> {
}