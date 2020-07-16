package com.ecom.product.dalc.repositories;

import com.ecom.product.dalc.entities.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaxRepository extends JpaRepository<Tax, Long> {
}
