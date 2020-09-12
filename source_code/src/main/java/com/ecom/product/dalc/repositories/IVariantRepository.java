package com.ecom.product.dalc.repositories;

import com.ecom.product.dalc.entities.Variant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVariantRepository extends JpaRepository<Variant, Long> {
}
