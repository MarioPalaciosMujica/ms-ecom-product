package com.ecom.product.dalc.repositories;

import com.ecom.product.dalc.entities.Catalogue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICatalogueRepository extends JpaRepository<Catalogue, Long> {
}
