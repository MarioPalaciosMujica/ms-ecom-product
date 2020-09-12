package com.ecom.product.service;

import com.ecom.product.dalc.entities.Catalogue;
import com.ecom.product.dalc.repositories.ICatalogueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CatalogueService {

    @Autowired private ICatalogueRepository catalogueRepository;

    public Catalogue save(@NotNull Catalogue entity){
        entity.setIdCatalogue(null);
        entity.setCreated(new Date());
        entity.setModified(null);
        catalogueRepository.save(entity);
        return entity;
    }

    public Catalogue findById(@NotNull Long id){
        Optional<Catalogue> entity = catalogueRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else {
            return null;
        }
    }

    public List<Catalogue> findAll(){
        return catalogueRepository.findAll();
    }

    public boolean update(@NotNull Catalogue entity){
        Catalogue original = this.findById(entity.getIdCatalogue());
        if(original != null){
            entity.setCreated(original.getCreated());
            entity.setModified(new Date());
            catalogueRepository.save(entity);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean deleteById(@NotNull Long id){
        if(this.findById(id) != null){
            catalogueRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }
}
