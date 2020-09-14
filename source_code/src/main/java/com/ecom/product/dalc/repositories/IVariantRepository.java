package com.ecom.product.dalc.repositories;

import com.ecom.product.dalc.entities.Variant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVariantRepository extends JpaRepository<Variant, Long> {
}
