package com.ecom.product.service;

import com.ecom.product.dalc.entities.FeaturedProduct;
import com.ecom.product.dalc.repositories.IFeaturedProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FeaturedProductService {

    @Autowired private IFeaturedProductRepository featuredProductRepository;

    public FeaturedProduct save(@NotNull FeaturedProduct entity){
        entity.setIdFeaturedProduct(null);
        entity.setCreated(new Date());
        entity.setModified(null);
        featuredProductRepository.save(entity);
        return entity;
    }

    public FeaturedProduct findById(@NotNull Long id){
        Optional<FeaturedProduct> entity = featuredProductRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else{
            return null;
        }
    }

    public List<FeaturedProduct> findAll(){
        return featuredProductRepository.findAll();
    }

    public boolean update(@NotNull FeaturedProduct entity){
        entity.setModified(new Date());
        featuredProductRepository.save(entity);
        return true;
    }

    public boolean deleteById(@NotNull Long id){
        if(this.findById(id) != null){
            featuredProductRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

    public List<FeaturedProduct> findAllByFeatureType(@NotNull Long idFeatureType){
        return featuredProductRepository.findAllByFeatureType(idFeatureType);
    }

    public boolean unlinkFeaturedProductsFromFeatureTypeById(@NotNull Long idFeatureType){
        List<FeaturedProduct> featuredProductList = this.findAllByFeatureType(idFeatureType);
        for (FeaturedProduct featuredProduct : featuredProductList){
            featuredProduct.setFeatureType(null);
            this.update(featuredProduct);
        }
        return true;
    }
}
