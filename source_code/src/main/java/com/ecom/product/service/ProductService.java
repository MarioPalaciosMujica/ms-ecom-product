package com.ecom.product.service;

import com.ecom.product.dalc.entities.FeaturedProduct;
import com.ecom.product.dalc.entities.Product;
import com.ecom.product.dalc.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired private IProductRepository productRepository;
    @Autowired private FeaturedProductService featuredProductService;

    public Product save(@NotNull Product entity){
        entity.setIdProduct(null);
        entity.setRating(0);
        entity.setCreated(new Date());
        entity.setModified(null);
        return productRepository.save(entity);
    }

    public Product findById(@NotNull Long id){
        Optional<Product> entity = productRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else{
            return null;
        }
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public boolean update(@NotNull Product entity){
        Product original = this.findById(entity.getIdProduct());
        if(original != null){
            entity.setCreated(original.getCreated());
            entity.setModified(new Date());
            productRepository.save(entity);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean deleteById(@NotNull Long id){
        Product entity = this.findById(id);
        if(entity != null){
            productRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

    public List<Product> findAllActives(){
        return productRepository.findAllActives();
    }

    public List<Product> findAllByTag(@NotNull Long idTag){
        return productRepository.findAllByTag(idTag);
    }

    public List<Product> findAllActivesByTag(@NotNull Long idTag){
        return productRepository.findAllActivesByTag(idTag);
    }

    public List<Product> findAllByBrand(@NotNull Long idBrand){
        return productRepository.findAllByBrand(idBrand);
    }

    public List<Product> findAllActivesByBrand(@NotNull Long idTag){
        return productRepository.findAllActivesByBrand(idTag);
    }

    public List<Product> findAllByDiscount(@NotNull Long idDiscount){
        return productRepository.findAllByDiscount(idDiscount);
    }

    public List<Product> findAllActivesByDiscount(@NotNull Long idDiscount){
        return productRepository.findAllActivesByDiscount(idDiscount);
    }

    public List<Product> findAllByCategory(@NotNull Long idCategory){
        return productRepository.findAllByCategory(idCategory);
    }

    public List<Product> findAllActivesByCategory(@NotNull Long idCategory){
        return productRepository.findAllActivesByCategory(idCategory);
    }

    public List<Product> findAllByNameLike(@NotNull String partialName){
        return productRepository.findByNameContainingIgnoreCase(partialName);
    }

    public List<Product> findAllByFeatureType(@NotNull Long idFeatureType){
        List<Product> productList = new ArrayList<>();
        for (FeaturedProduct featuredProduct : featuredProductService.findAllByFeatureType(idFeatureType)){
            productList.add(featuredProduct.getProduct());
        }
        return productList;
    }

    public List<Product> findAllActivesByFeatureType(@NotNull Long idFeatureType){
        List<Product> productList = new ArrayList<>();
        for (FeaturedProduct featuredProduct : featuredProductService.findAllByFeatureType(idFeatureType)){
            if(featuredProduct.getProduct().isActive()){
                productList.add(featuredProduct.getProduct());
            }
        }
        return productList;
    }

    public List<Product> findAllByPriceRange(@NotNull BigDecimal minPrice, @NotNull BigDecimal maxPrice){
        return productRepository.findAllByPriceRange(minPrice, maxPrice);
    }


    public boolean unlinkProductFromBrandById(@NotNull Long idBrand){
        List<Product> productList = this.findAllByBrand(idBrand);
        for (Product product : productList){
            product.setBrand(null);
            this.update(product);
        }
        return true;
    }

    public boolean unlinkProductFromDiscountById(@NotNull Long idDiscount){
        List<Product> productList = this.findAllByDiscount(idDiscount);
        for (Product product : productList){
            product.setDiscount(null);
            this.update(product);
        }
        return true;
    }

    public boolean updateRanking(@NotNull Long id){
        Product entity = this.findById(id);
        if(entity != null){
            if(entity.getRating() <= 9){
                entity.setRating(entity.getRating()+1);
                this.update(entity);
            }
            return true;
        }
        else{
            return false;
        }
    }
}
