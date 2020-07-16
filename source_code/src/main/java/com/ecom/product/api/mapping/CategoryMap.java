package com.ecom.product.api.mapping;

import com.ecom.product.api.models.CategoryModel;
import com.ecom.product.dalc.entities.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMap {

    public CategoryModel toModel(Category entity){
        if(entity != null){
            CategoryModel model = new CategoryModel();
            model.setIdCategory(entity.getIdCategory());
            model.setName(entity.getName());
            model.setCreated(entity.getCreated());
            model.setModified(entity.getModified());
            return model;
        }
        else{
            return null;
        }
    }

    public Category toEntity(CategoryModel model){
        if(model != null){
            Category entity = new Category();
            entity.setIdCategory(model.getIdCategory());
            entity.setName(model.getName());
            entity.setCreated(model.getCreated());
            entity.setModified(model.getModified());
            return entity;
        }
        else{
            return null;
        }
    }

    public List<CategoryModel> toModelList(List<Category> listEntity){
        List<CategoryModel> modelList = new ArrayList<>();
        for (Category entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<Category> toEntityList(List<CategoryModel> listModel){
        List<Category> entityList = new ArrayList<>();
        for (CategoryModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
