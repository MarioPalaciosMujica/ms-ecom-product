package com.ecom.product.dalc.repositories;

import com.ecom.product.dalc.entities.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMaterialRepository extends JpaRepository<Material, Long> {
}
