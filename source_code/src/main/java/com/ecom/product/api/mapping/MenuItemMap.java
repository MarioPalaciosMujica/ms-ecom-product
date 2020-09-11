package com.ecom.product.api.mapping;

import com.ecom.product.api.models.MenuItemModel;
import com.ecom.product.dalc.entities.MenuItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MenuItemMap {

    public MenuItemModel toModel(MenuItem entity){
        if(entity != null){
            MenuItemModel model = new MenuItemModel();
            model.setPath(entity.getPath());
            model.setTitle(entity.getTitle());
            model.setType(entity.getType());
            if(entity.getChildren() != null){
                model.setChildren(this.toModelList(entity.getChildren()));
            }
            return model;
        }
        else{
            return null;
        }
    }

    public MenuItem toEntity(MenuItemModel model){
        if(model != null){
            MenuItem entity = new MenuItem();
            entity.setPath(model.getPath());
            entity.setTitle(model.getTitle());
            entity.setType(model.getType());
            if(model.getChildren() != null){
                entity.setChildren(this.toEntityList(model.getChildren()));
            }
            return entity;
        }
        else{
            return null;
        }
    }

    public List<MenuItemModel> toModelList(List<MenuItem> listEntity){
        List<MenuItemModel> modelList = new ArrayList<>();
        for (MenuItem entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<MenuItem> toEntityList(List<MenuItemModel> listModel){
        List<MenuItem> entityList = new ArrayList<>();
        for (MenuItemModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
