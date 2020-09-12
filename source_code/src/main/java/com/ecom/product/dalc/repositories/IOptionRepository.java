package com.ecom.product.dalc.repositories;

import com.ecom.product.dalc.entities.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOptionRepository extends JpaRepository<Option, Long> {
}
