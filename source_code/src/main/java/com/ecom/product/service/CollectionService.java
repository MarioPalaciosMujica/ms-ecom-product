package com.ecom.product.service;

import com.ecom.product.dalc.entities.Collection;
import com.ecom.product.dalc.repositories.ICollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CollectionService {

    @Autowired private ICollectionRepository featuredProductRepository;

    public Collection save(@NotNull Collection entity){
        entity.setIdFeaturedProduct(null);
        entity.setCreated(new Date());
        entity.setModified(null);
        featuredProductRepository.save(entity);
        return entity;
    }

    public Collection findById(@NotNull Long id){
        Optional<Collection> entity = featuredProductRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else{
            return null;
        }
    }

    public List<Collection> findAll(){
        return featuredProductRepository.findAll();
    }

    public boolean update(@NotNull Collection entity){
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

    public List<Collection> findAllByFeatureType(@NotNull Long idFeatureType){
        return featuredProductRepository.findAllByFeatureType(idFeatureType);
    }

    public boolean unlinkFeaturedProductsFromFeatureTypeById(@NotNull Long idFeatureType){
        List<Collection> collectionList = this.findAllByFeatureType(idFeatureType);
        for (Collection collection : collectionList){
            collection.setFeatureType(null);
            this.update(collection);
        }
        return true;
    }
}
