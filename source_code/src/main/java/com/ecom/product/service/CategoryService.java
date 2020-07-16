package com.ecom.product.service;

import com.ecom.product.dalc.entities.Category;
import com.ecom.product.dalc.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired private ICategoryRepository categoryRepository;
    @Autowired private ProductService productService;

    public Category save(@NotNull Category entity){
        entity.setIdCategory(null);
        entity.setCreated(new Date());
        entity.setModified(null);
        categoryRepository.save(entity);
        return entity;
    }

    public Category findById(@NotNull Long id){
        Optional<Category> entity = categoryRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else {
            return null;
        }
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public boolean update(@NotNull Category entity){
        Category original = this.findById(entity.getIdCategory());
        if(original != null){
            entity.setCreated(original.getCreated());
            entity.setModified(new Date());
            categoryRepository.save(entity);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean deleteById(@NotNull Long id){
        if(this.findById(id) != null){
            categoryRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }
}
