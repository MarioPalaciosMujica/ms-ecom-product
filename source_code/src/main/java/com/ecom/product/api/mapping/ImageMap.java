package com.ecom.product.api.mapping;

import com.ecom.product.api.models.ImageModel;
import com.ecom.product.dalc.entities.Image;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ImageMap {

    public ImageModel toModel(Image entity){
        if(entity != null){
            ImageModel model = new ImageModel();
            model.setIdImage(entity.getIdImage());
            model.setAlt(entity.getAlt());
            model.setSrc(entity.getSrc());
            model.setCreated(entity.getCreated());
            model.setModified(entity.getModified());
            return model;
        }
        else{
            return null;
        }
    }

    public Image toEntity(ImageModel model){
        if(model != null){
            Image entity = new Image();
            entity.setIdImage(model.getIdImage());
            entity.setAlt(model.getAlt());
            entity.setSrc(model.getSrc());
            entity.setCreated(model.getCreated());
            entity.setModified(model.getModified());
            return entity;
        }
        else{
            return null;
        }
    }

    public List<ImageModel> toModelList(List<Image> listEntity){
        List<ImageModel> modelList = new ArrayList<>();
        for (Image entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<Image> toEntityList(List<ImageModel> listModel){
        List<Image> entityList = new ArrayList<>();
        for (ImageModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }

}
