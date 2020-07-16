package com.ecom.product.dalc.repositories;

import com.ecom.product.dalc.entities.ProductDiscount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductDiscountRepository extends JpaRepository<ProductDiscount, Long> {
}
