package com.ecom.product.service;

import com.ecom.product.dalc.entities.ProductTax;
import com.ecom.product.dalc.repositories.IProductTaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaxService {

    @Autowired private IProductTaxRepository taxRepository;

    public ProductTax save(@NotNull ProductTax entity){
        entity.setIdTax(null);
        entity.setCreated(new Date());
        entity.setModified(null);
        taxRepository.save(entity);
        return entity;
    }

    public ProductTax findById(@NotNull Long id){
        Optional<ProductTax> entity = taxRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else{
            return null;
        }
    }

    public List<ProductTax> findAll(){
        return taxRepository.findAll();
    }

    public boolean update(@NotNull ProductTax entity){
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
