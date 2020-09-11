package com.ecom.product.api.mapping;

import com.ecom.product.api.models.MenuSectionModel;
import com.ecom.product.dalc.entities.MenuSection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MenuSectionMap {

    @Autowired private MenuItemMap menuItemMap;

    public MenuSectionModel toModel(MenuSection entity){
        if(entity != null){
            MenuSectionModel model = new MenuSectionModel();
            model.setTitle(entity.getTitle());
            model.setType(entity.getType());
            model.setActive(entity.isActive());
            model.setChildren(menuItemMap.toModelList(entity.getChildren()));
            return model;
        }
        else{
            return null;
        }
    }

    public MenuSection toEntity(MenuSectionModel model){
        if(model != null){
            MenuSection entity = new MenuSection();
            entity.setTitle(model.getTitle());
            entity.setType(model.getType());
            entity.setActive(model.isActive());
            entity.setChildren(menuItemMap.toEntityList(model.getChildren()));
            return entity;
        }
        else{
            return null;
        }
    }

    public List<MenuSectionModel> toModelList(List<MenuSection> listEntity){
        List<MenuSectionModel> modelList = new ArrayList<>();
        for (MenuSection entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<MenuSection> toEntityList(List<MenuSectionModel> listModel){
        List<MenuSection> entityList = new ArrayList<>();
        for (MenuSectionModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
