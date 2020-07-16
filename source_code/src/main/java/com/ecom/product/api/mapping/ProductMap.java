package com.ecom.product.api.mapping;

import com.ecom.product.api.models.ProductModel;
import com.ecom.product.dalc.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class ProductMap {

    @Autowired private ImageMap imageMap;
    @Autowired private CategoryMap categoryMap;
    @Autowired private BrandMap brandMap;
    @Autowired private ProductDiscountMap productDiscountMap;
    @Autowired private TagMap tagMap;
    @Autowired private ProductTaxMap productTaxMap;

    public ProductModel toModel(Product entity){
        if(entity != null){
            ProductModel model = new ProductModel();
            model.setIdProduct(entity.getIdProduct());
            model.setName(entity.getName());
            model.setDescription(entity.getDescription());
            model.setRating(entity.getRating());
            model.setPrice(entity.getPrice());
            model.setActive(entity.isActive());
            model.setCreated(entity.getCreated());
            model.setModified(entity.getModified());
            model.setImage(this.imageMap.toModel(entity.getImage()));
            model.setBrand(this.brandMap.toModel(entity.getBrand()));
            model.setProductDiscount(this.productDiscountMap.toModel(entity.getProductDiscount()));
            model.setCategories(this.categoryMap.toModelList(new ArrayList<>(entity.getCategories())));
            model.setTags(this.tagMap.toModelList(new ArrayList<>(entity.getTags())));
            model.setProductTaxes(this.productTaxMap.toModelList(new ArrayList<>(entity.getProductTaxes())));
            return model;
        }
        else{
            return null;
        }
    }

    public Product toEntity(ProductModel model){
        if(model != null){
            Product entity = new Product();
            entity.setIdProduct(model.getIdProduct());
            entity.setName(model.getName());
            entity.setDescription(model.getDescription());
            entity.setRating(model.getRating());
            entity.setPrice(model.getPrice());
            entity.setActive(model.isActive());
            entity.setCreated(model.getCreated());
            entity.setModified(model.getModified());
            entity.setImage(this.imageMap.toEntity(model.getImage()));
            entity.setBrand(this.brandMap.toEntity(model.getBrand()));
            entity.setProductDiscount(this.productDiscountMap.toEntity(model.getProductDiscount()));
            entity.setCategories(new HashSet<>(this.categoryMap.toEntityList(model.getCategories())));
            entity.setTags(new HashSet<>(this.tagMap.toEntityList(model.getTags())));
            entity.setProductTaxes(new HashSet<>(this.productTaxMap.toEntityList(model.getProductTaxes())));
            return entity;
        }
        else{
            return null;
        }
    }

    public List<ProductModel> toModelList(List<Product> listEntity){
        List<ProductModel> modelList = new ArrayList<>();
        for (Product entity : listEntity){
            modelList.add(this.toModel(entity));
        }
        return modelList;
    }

    public List<Product> toEntityList(List<ProductModel> listModel){
        List<Product> entityList = new ArrayList<>();
        for (ProductModel model : listModel){
            entityList.add(this.toEntity(model));
        }
        return entityList;
    }
}
