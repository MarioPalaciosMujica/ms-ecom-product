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

    @Query("select p from Product p where p.isNew = true")
    List<Product> findAllNew();

    @Query("select p from Product p where p.isNew = true and p.isActive = true")
    List<Product> findAllActivesNew();

    @Query("select p from Product p where p.isNew = false")
    List<Product> findAllNotNew();

    @Query("select p from Product p where p.isNew = false and p.isActive = true")
    List<Product> findAllActivesNotNew();

    @Query("select p from Product p where p.isSale = true")
    List<Product> findAllOnSale();

    @Query("select p from Product p where p.isSale = true and p.isActive = true")
    List<Product> findAllActivesOnSale();

    @Query("select p from Product p where p.isSale = false")
    List<Product> findAllNotOnSale();

    @Query("select p from Product p where p.isSale = false and p.isActive = true")
    List<Product> findAllActivesNotOnSale();

    @Query("select p from Product p where p.collection.idCollection = :idCollection")
    List<Product> findAllByCollection(@Param("idCollection") Long idCollection);

    @Query("select p from Product p where p.collection.idCollection = :idCollection and p.isActive = true")
    List<Product> findAllActivesByCollection(@Param("idCollection") Long idCollection);

    @Query("select p from Product p where p.stock >= 1 or p.stock is null")
    List<Product> findAllInStock();

    @Query("select p from Product p where (p.stock >= 1 or p.stock is null) and p.isActive = true")
    List<Product> findAllActivesInStock();

    @Query("select p from Product p where p.stock <= 0 and p.stock is not null")
    List<Product> findAllNotInStock();

    @Query("select p from Product p join p.tags t where t.idTag = :idTag")
    List<Product> findAllByTag(@Param("idTag") Long idTag);

    @Query("select p from Product p join p.tags t where t.idTag = :idTag and p.isActive = true")
    List<Product> findAllActivesByTag(@Param("idTag") Long idTag);

    @Query("select p from Product p join p.categories c where c.idCategory = :idCategory")
    List<Product> findAllByCategory(@Param("idCategory") Long idCategory);

    @Query("select p from Product p join p.categories c where c.idCategory = :idCategory and p.isActive = true")
    List<Product> findAllActivesByCategory(@Param("idCategory") Long idCategory);

    @Query("select p from Product p where lower(p.title) like %:partialTitle%")
    List<Product> findAllByTitle(@Param("partialTitle") String partialTitle);

    @Query("select p from Product p where lower(p.title) like %:partialTitle% and p.isActive = true")
    List<Product> findAllActivesByTitle(@Param("partialTitle") String partialTitle);

    @Query("select p from Product p where p.price >= :minPrice and p.price <= :maxPrice and p.isActive = true order by p.price desc")
    List<Product> findAllActivesByPriceRange(@Param("minPrice") BigDecimal minPrice, @Param("maxPrice") BigDecimal maxPrice);

}
