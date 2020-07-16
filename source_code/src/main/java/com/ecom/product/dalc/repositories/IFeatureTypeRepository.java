package com.ecom.product.dalc.repositories;

import com.ecom.product.dalc.entities.FeatureType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFeatureTypeRepository extends JpaRepository<FeatureType, Long> {
}
