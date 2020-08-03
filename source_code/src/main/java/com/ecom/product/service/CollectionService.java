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

    @Autowired private ICollectionRepository collectionRepository;

    public Collection save(@NotNull Collection entity){
        entity.setIdCollection(null);
        entity.setCreated(new Date());
        entity.setModified(null);
        collectionRepository.save(entity);
        return entity;
    }

    public Collection findById(@NotNull Long id){
        Optional<Collection> entity = collectionRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else{
            return null;
        }
    }

    public List<Collection> findAll(){
        return collectionRepository.findAll();
    }

    public boolean update(@NotNull Collection entity){
        entity.setModified(new Date());
        collectionRepository.save(entity);
        return true;
    }

    public boolean deleteById(@NotNull Long id){
        if(this.findById(id) != null){
            collectionRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

}
