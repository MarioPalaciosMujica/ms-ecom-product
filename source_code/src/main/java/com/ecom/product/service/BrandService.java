package com.ecom.product.service;

import com.ecom.product.dalc.entities.Brand;
import com.ecom.product.dalc.repositories.IBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BrandService {

    @Autowired private IBrandRepository brandRepository;
    @Autowired private ProductService productService;

    public Brand save(@NotNull Brand entity){
        entity.setIdBrand(null);
        entity.setCreated(new Date());
        entity.setModified(null);
        brandRepository.save(entity);
        return entity;
    }

    public Brand findById(@NotNull Long id){
        Optional<Brand> entity = brandRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else {
            return null;
        }
    }

    public List<Brand> findAll(){
        return brandRepository.findAll();
    }

    public boolean update(@NotNull Brand entity){
        Brand original = this.findById(entity.getIdBrand());
        if(original != null){
            entity.setCreated(original.getCreated());
            entity.setModified(new Date());
            brandRepository.save(entity);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean deleteById(@NotNull Long id){
        if(this.findById(id) != null){
            brandRepository.deleteById(id);
            productService.unlinkProductFromBrandById(id);
            return true;
        }
        else {
            return false;
        }
    }

}
