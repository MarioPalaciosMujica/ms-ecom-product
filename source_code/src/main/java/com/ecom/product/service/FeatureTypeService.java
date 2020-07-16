package com.ecom.product.service;

import com.ecom.product.dalc.entities.FeatureType;
import com.ecom.product.dalc.repositories.IFeatureTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FeatureTypeService {

    @Autowired private IFeatureTypeRepository featureTypeRepository;
    @Autowired private FeaturedProductService featuredProductService;

    public FeatureType save(@NotNull FeatureType entity){
        entity.setIdFeatureType(null);
        entity.setCreated(new Date());
        entity.setModified(null);
        featureTypeRepository.save(entity);
        return entity;
    }

    public FeatureType findById(@NotNull Long id){
        Optional<FeatureType> entity = featureTypeRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else {
            return null;
        }
    }

    public List<FeatureType> findAll(){
        return featureTypeRepository.findAll();
    }

    public boolean update(@NotNull FeatureType entity){
        entity.setModified(new Date());
        featureTypeRepository.save(entity);
        return true;
    }

    public boolean deleteById(@NotNull Long id){
        if(this.findById(id) != null){
            featureTypeRepository.deleteById(id);
            featuredProductService.unlinkFeaturedProductsFromFeatureTypeById(id);
            return true;
        }
        else{
            return false;
        }
    }
}
