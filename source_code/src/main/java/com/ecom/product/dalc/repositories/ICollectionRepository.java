package com.ecom.product.dalc.repositories;

import com.ecom.product.dalc.entities.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICollectionRepository extends JpaRepository<Collection, Long> {
}
