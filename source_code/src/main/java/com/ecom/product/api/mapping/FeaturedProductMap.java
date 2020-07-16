package com.ecom.product.api.mapping;

import com.ecom.product.api.models.FeaturedProductModel;
import com.ecom.product.dalc.entities.FeaturedProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FeaturedProductMap {

    @Autowired private FeatureTypeMap featureTypeMap;
    @Autowired private ProductMap productMap;

    public FeaturedProductModel toModel(FeaturedProduct entity){
        if(entity != null){
            FeaturedProductModel model = new FeaturedProductModel();
            model.setIdFeaturedProduct(entity.getIdFeaturedProduct());
            model.setCreated(entity.getCreated());
            model.setModified(entity.getModified());
            model.setFeatureType(this.featureTypeMap.toModel(entity.getFeatureType()));
            model.setProduct(this.productMap.toModel(entity.getProduct()));
            return model;
        }
        else{
            return null;
        }
    }

    public FeaturedProduct toEntity(FeaturedProductModel model){
        if(model != null){
            FeaturedProduct entity = new FeaturedProduct();
            entity.setIdFeaturedProduct(model.getIdFeaturedProduct());
            entity.setCreated(model.getCreated());
            entity.setModified(model.getModified());
            entity.setFeatureType(this.featureTypeMap.toEntity(model.getFeatureType()));
            entity.setProduct(this.productMap.toEntity(model.getProduct()));
            return entity;
        }
        else{
            return null;
        }
    }

    public List<FeaturedProductModel> toModelList(List<FeaturedProduct> listEntity){
        List<FeaturedProductModel> modelList = new ArrayList<>();
        for (FeaturedProduct entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<FeaturedProduct> toEntityList(List<FeaturedProductModel> listModel){
        List<FeaturedProduct> entityList = new ArrayList<>();
        for (FeaturedProductModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
