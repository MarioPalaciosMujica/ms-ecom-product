package com.ecom.product.dalc.repositories;

import com.ecom.product.dalc.entities.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICollectionRepository extends JpaRepository<Collection, Long> {

}
