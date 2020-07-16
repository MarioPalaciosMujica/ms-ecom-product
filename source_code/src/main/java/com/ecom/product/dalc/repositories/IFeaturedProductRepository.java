package com.ecom.product.dalc.repositories;

import com.ecom.product.dalc.entities.FeaturedProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFeaturedProductRepository extends JpaRepository<FeaturedProduct, Long> {

    @Query("select f from FeaturedProduct f where f.featureType.idFeatureType = :idFeatureType")
    List<FeaturedProduct> findAllByFeatureType(@Param("idFeatureType") Long idFeatureType);
}
