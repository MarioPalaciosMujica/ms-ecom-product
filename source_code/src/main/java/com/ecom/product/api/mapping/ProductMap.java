package com.ecom.product.api.mapping;

import com.ecom.product.api.models.ProductModel;
import com.ecom.product.dalc.entities.Product;
import com.ecom.product.tools.DateFormat;
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
    @Autowired private VariantMap variantMap;
    @Autowired private OptionMap optionMap;
    @Autowired private ProductMaterialMap productMaterialMap;
    @Autowired private DateFormat dateFormat;

    public ProductModel toModel(Product entity){
        if(entity != null){
            ProductModel model = new ProductModel();
            model.setIdProduct(entity.getIdProduct());
            model.setTitle(entity.getTitle());
            model.setDescription(entity.getDescription());
            model.setRating(entity.getRating());
            model.setNew(entity.isNew());
            model.setSale(entity.isSale());
            model.setDiscountPercentage(entity.getDiscountPercentage());
            model.setCurrentBasePrice(entity.getCurrentBasePrice());
            model.setCurrentTotalPrice(entity.getCurrentTotalPrice());
            model.setStock(entity.getStock());
            model.setCapacityQty(entity.isCapacityQty());
            model.setActive(entity.isActive());
            model.setCreated(dateFormat.dateToString(entity.getCreated()));
            model.setModified(dateFormat.dateToString(entity.getModified()));
            model.setBrand(brandMap.toModel(entity.getBrand()));
            model.setCollection(collectionMap.toModel(entity.getCollection()));
            model.setImages(imageMap.toModelList(new ArrayList<>(entity.getImages())));
            model.setCategories(categoryMap.toModelList(new ArrayList<>(entity.getCategories())));
            model.setTags(tagMap.toModelList(new ArrayList<>(entity.getTags())));
            model.setProductMaterials(productMaterialMap.toModelList(new ArrayList<>(entity.getProductMaterials())));
            model.setOptions(optionMap.toModelList(new ArrayList<>(entity.getOptions())));
            model.setVariants(variantMap.toModelList(new ArrayList<>(entity.getVariants())));
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
            entity.setNew(model.isNew());
            entity.setSale(model.isSale());
            entity.setDiscountPercentage(model.getDiscountPercentage());
            entity.setCurrentBasePrice(model.getCurrentBasePrice());
            entity.setCurrentTotalPrice(model.getCurrentTotalPrice());
            entity.setStock(model.getStock());
            entity.setCapacityQty(model.isCapacityQty());
            entity.setActive(model.isActive());
            entity.setCreated(dateFormat.stringToDate(model.getCreated()));
            entity.setModified(dateFormat.stringToDate(model.getModified()));
            entity.setBrand(brandMap.toEntity(model.getBrand()));
            entity.setCollection(collectionMap.toEntity(model.getCollection()));
            entity.setImages(new HashSet<>(imageMap.toEntityList(model.getImages())));
            entity.setCategories(new HashSet<>(categoryMap.toEntityList(model.getCategories())));
            entity.setTags(new HashSet<>(tagMap.toEntityList(model.getTags())));
            entity.setOptions(new HashSet<>(optionMap.toEntityList(model.getOptions())));
            entity.setVariants(new HashSet<>(variantMap.toEntityList(model.getVariants())));
            entity.setProductMaterials(new HashSet<>(productMaterialMap.toEntityList(model.getProductMaterials())));
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
