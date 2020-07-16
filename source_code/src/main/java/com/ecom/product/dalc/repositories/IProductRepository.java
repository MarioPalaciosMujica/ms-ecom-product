package com.ecom.product.dalc.repositories;

import com.ecom.product.dalc.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where p.isActive = true")
    List<Product> findAllActives();

    @Query("select p from Product p join p.brand b where b.idBrand = :idBrand")
    List<Product> findAllByBrand(@Param("idBrand") Long idBrand);

    @Query("select p from Product p join p.brand b where b.idBrand = :idBrand and p.isActive = true")
    List<Product> findAllActivesByBrand(@Param("idBrand") Long idBrand);

    @Query("select p from Product p join p.discount d where d.idDiscount = :idDiscount")
    List<Product> findAllByDiscount(@Param("idDiscount") Long idDiscount);

    @Query("select p from Product p join p.discount d where d.idDiscount = :idDiscount and p.isActive = true")
    List<Product> findAllActivesByDiscount(@Param("idDiscount") Long idDiscount);

    @Query("select p from Product p join p.tags t where t.idTag = :idTag")
    List<Product> findAllByTag(@Param("idTag") Long idTag);

    @Query("select p from Product p join p.tags t where t.idTag = :idTag and p.isActive = true")
    List<Product> findAllActivesByTag(@Param("idTag") Long idTag);

    @Query("select p from Product p join p.categories c where c.idCategory = :idCategory")
    List<Product> findAllByCategory(@Param("idCategory") Long idCategory);

    @Query("select p from Product p join p.categories c where c.idCategory = :idCategory and p.isActive = true")
    List<Product> findAllActivesByCategory(@Param("idCategory") Long idCategory);

    List<Product> findByNameContainingIgnoreCase(@Param("partialName") String partialName);

    //TODO: find actives by partial name

    @Query("select p from Product p where p.price >= :minPrice and p.price <= :maxPrice order by p.price desc")
    List<Product> findAllByPriceRange(@Param("minPrice") BigDecimal minPrice, @Param("maxPrice") BigDecimal maxPrice);

}
