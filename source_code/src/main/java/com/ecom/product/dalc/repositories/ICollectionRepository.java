package com.ecom.product.dalc.repositories;

import com.ecom.product.dalc.entities.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICollectionRepository extends JpaRepository<Collection, Long> {

//    @Query("select c from Collection c join c.products p")
//    List<Collection> findAllWithProducts();
//
//    @Query("select c from Collection c join c.products p where p.isActive = true")
//    List<Collection> findAllWithProductsActives();
//
//    @Query("select c from Collection c join c.products p where c.idCollection = :idCollection")
//    Optional<Collection> findByIdlWithProducts(@Param("idCollection") Long idCollection);
//
//    @Query("select c from Collection c join c.products p where c.idCollection = :idCollection and p.isActive = true")
//    Optional<Collection> findByIdlWithProductsActives(@Param("idCollection") Long idCollection);

}
