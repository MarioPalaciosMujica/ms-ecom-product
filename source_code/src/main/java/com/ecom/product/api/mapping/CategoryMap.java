package com.ecom.product.api.mapping;

import com.ecom.product.api.models.CategoryModel;
import com.ecom.product.dalc.entities.Category;
import com.ecom.product.tools.DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMap {

    @Autowired private CatalogueMap catalogueMap;
    @Autowired private DateFormat dateFormat;

    public CategoryModel toModel(Category entity){
        if(entity != null){
            CategoryModel model = new CategoryModel();
            model.setIdCategory(entity.getIdCategory());
            model.setName(entity.getName());
            model.setCreated(dateFormat.dateToString(entity.getCreated()));
            model.setModified(dateFormat.dateToString(entity.getModified()));
            model.setCatalogue(catalogueMap.toModel(entity.getCatalogue()));
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
            entity.setCreated(dateFormat.stringToDate(model.getCreated()));
            entity.setModified(dateFormat.stringToDate(model.getModified()));
            entity.setCatalogue(catalogueMap.toEntity(model.getCatalogue()));
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
