package com.ecom.product.dalc.repositories;

import com.ecom.product.dalc.entities.UnitNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUnitNumberRepository extends JpaRepository<UnitNumber, Long> {
}
