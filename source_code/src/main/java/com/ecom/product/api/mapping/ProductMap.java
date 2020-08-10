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
    @Autowired private TagMap tagMap;
    @Autowired private CollectionMap collectionMap;
    @Autowired private MaterialMap materialMap;

    public ProductModel toModel(Product entity){
        if(entity != null){
            ProductModel model = new ProductModel();
            model.setIdProduct(entity.getIdProduct());
            model.setTitle(entity.getTitle());
            model.setDescription(entity.getDescription());
            model.setRating(entity.getRating());
            model.setPrice(entity.getPrice());

            model.setNew(entity.isNew());
            model.setSale(entity.isSale());
            model.setDiscountPercentage(entity.getDiscountPercentage());
            model.setPriceDiscount(entity.getPriceDiscount());
            model.setStock(entity.getStock());

            model.setActive(entity.isActive());
            model.setCreated(entity.getCreated());
            model.setModified(entity.getModified());
//            model.setImage(this.imageMap.toModel(entity.getImage()));
            model.setBrand(this.brandMap.toModel(entity.getBrand()));

            model.setCollection(this.collectionMap.toModel(entity.getCollection()));
            model.setImages(this.imageMap.toModelList(new ArrayList<>(entity.getImages())));

            model.setCategories(this.categoryMap.toModelList(new ArrayList<>(entity.getCategories())));
            model.setTags(this.tagMap.toModelList(new ArrayList<>(entity.getTags())));
            model.setMaterials(this.materialMap.toModelList(new ArrayList<>(entity.getMaterials())));
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
            entity.setTitle(model.getTitle());
            entity.setDescription(model.getDescription());
            entity.setRating(model.getRating());
            entity.setPrice(model.getPrice());

            entity.setNew(model.isNew());
            entity.setSale(model.isSale());
            entity.setDiscountPercentage(model.getDiscountPercentage());
            entity.setPriceDiscount(model.getPriceDiscount());
            entity.setStock(model.getStock());

            entity.setActive(model.isActive());
            entity.setCreated(model.getCreated());
            entity.setModified(model.getModified());
//            entity.setImage(this.imageMap.toEntity(model.getImage()));
            entity.setBrand(this.brandMap.toEntity(model.getBrand()));

            entity.setCollection(this.collectionMap.toEntity(model.getCollection()));
            entity.setImages(new HashSet<>(this.imageMap.toEntityList(model.getImages())));

            entity.setCategories(new HashSet<>(this.categoryMap.toEntityList(model.getCategories())));
            entity.setTags(new HashSet<>(this.tagMap.toEntityList(model.getTags())));
            entity.setMaterials(new HashSet<>(this.materialMap.toEntityList(model.getMaterials())));
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
