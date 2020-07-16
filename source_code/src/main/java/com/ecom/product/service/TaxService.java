package com.ecom.product.service;

import com.ecom.product.dalc.entities.Tax;
import com.ecom.product.dalc.repositories.ITaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaxService {

    @Autowired private ITaxRepository taxRepository;

    public Tax save(@NotNull Tax entity){
        entity.setIdTax(null);
        entity.setCreated(new Date());
        entity.setModified(null);
        taxRepository.save(entity);
        return entity;
    }

    public Tax findById(@NotNull Long id){
        Optional<Tax> entity = taxRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else{
            return null;
        }
    }

    public List<Tax> findAll(){
        return taxRepository.findAll();
    }

    public boolean update(@NotNull Tax entity){
        entity.setModified(new Date());
        taxRepository.save(entity);
        return true;
    }

    public boolean deleteById(@NotNull Long id){
        if(this.findById(id) != null){
            taxRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

}
