package com.ecom.product.service;

import com.ecom.product.dalc.entities.Product;
import com.ecom.product.dalc.entities.Tag;
import com.ecom.product.dalc.entities.Variant;
import com.ecom.product.dalc.repositories.IProductRepository;
import com.ecom.product.tools.CurrencyCLP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired private IProductRepository productRepository;
    @Autowired private CollectionService collectionService;
    @Autowired private VariantService variantService;
    @Autowired private CurrencyCLP currencyCLP;

    // TEST OK
    public Product save(@NotNull Product entity){
        entity.setIdProduct(null);
        for (Variant variant : entity.getVariants()){
            variant.setIdVariant(null);
            if(variant.getSku() != null && variant.getSku() <= 0){
                variant.setSku(null);
            }
            variant.setBasePriceAmount(currencyCLP.roundClp(variant.getBasePriceAmount()));
            variant.setCreated(new Date());
            variant.setProduct(entity);
        }
        this.isProductSale(entity);
        entity.setNew(true);
        entity.setRating(0);
        entity.setCreated(new Date());
        entity.setModified(null);
        return productRepository.save(entity);
    }

    // TEST OK
    public Product findById(@NotNull Long id){
        Optional<Product> entity = productRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else{
            return null;
        }
    }

    // TEST OK
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    // TODO: TEST
    public boolean update(@NotNull Product entity){
        Product original = this.findById(entity.getIdProduct());
        if(original != null){
            for (Variant variant : entity.getVariants()){
                variant.setIdVariant(null);
                if(variant.getSku() != null && variant.getSku() <= 0){
                    variant.setSku(null);
                }
                variant.setBasePriceAmount(currencyCLP.roundClp(variant.getBasePriceAmount()));
                variant.setModified(new Date());
                variant.setProduct(entity);
            }
            entity.setCreated(original.getCreated());
            entity.setModified(new Date());
            this.isProductSale(entity);
            productRepository.save(entity);
            return true;
        }
        else{
            return false;
        }
    }

    // TODO: TEST
    public boolean deleteById(@NotNull Long id){
        Product entity = this.findById(id);
        if(entity != null){
            productRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

    // TODO: TEST
    public List<Product> findAllActives(){
        return productRepository.findAllActives();
    }

    // TODO: TEST
    public List<Product> findAllByTag(@NotNull Long idTag){
        return productRepository.findAllByTag(idTag);
    }

    // TODO: TEST
    public List<Product> findAllActivesByTag(@NotNull Long idTag){
        return productRepository.findAllActivesByTag(idTag);
    }

    // TODO: TEST
    public List<Product> findAllByTags(@NotNull List<Tag> tagList){
        List<Product> duplicateList = new ArrayList<>();
        List<Product> cleanList = new ArrayList<>();
        for (Tag tag : tagList){
            duplicateList.addAll(this.findAllByTag(tag.getIdTag()));
        }
        boolean isNotDuplicate = true;
        for (Product duplicateItem: duplicateList){
            if(cleanList.size() > 0){
                for (Product cleanItem: cleanList){
                    if(duplicateItem.getIdProduct() == cleanItem.getIdProduct()){
                        isNotDuplicate = false;
                    }
                }
                if(isNotDuplicate){
                    cleanList.add(duplicateItem);
                    isNotDuplicate = true;
                }
            }
            else {
                cleanList.add(duplicateItem);
                isNotDuplicate = true;
            }
        }
        return cleanList;
    }

    // TODO: TEST
    public List<Product> findAllActivesByTags(@NotNull List<Tag> tagList){
        List<Product> duplicateList = new ArrayList<>();
        List<Product> cleanList = new ArrayList<>();
        for (Tag tag : tagList){
            duplicateList.addAll(this.findAllActivesByTag(tag.getIdTag()));
        }
        boolean isNotDuplicate = true;
        for (Product duplicateItem: duplicateList){
            if(cleanList.size() > 0){
                for (Product cleanItem: cleanList){
                    if(duplicateItem.getIdProduct() == cleanItem.getIdProduct()){
                        isNotDuplicate = false;
                    }
                }
                if(isNotDuplicate){
                    cleanList.add(duplicateItem);
                    isNotDuplicate = true;
                }
            }
            else {
                cleanList.add(duplicateItem);
                isNotDuplicate = true;
            }
        }
        return cleanList;
    }

    // TODO: TEST
    public List<Product> findAllByBrand(@NotNull Long idBrand){
        return productRepository.findAllByBrand(idBrand);
    }

    // TODO: TEST
    public List<Product> findAllActivesByBrand(@NotNull Long idTag){
        return productRepository.findAllActivesByBrand(idTag);
    }

    // TODO: TEST
    public List<Product> findAllNew(){
        return productRepository.findAllNew();
    }

    // TODO: TEST
    public List<Product> findAllActivesNew(){
        return productRepository.findAllActivesNew();
    }

    // TODO: TEST
    public List<Product> findAllNotNew(){
        return productRepository.findAllNotNew();
    }

    // TODO: TEST
    public List<Product> findAllActivesNotNew(){
        return productRepository.findAllActivesNotNew();
    }

    // TODO: TEST
    public List<Product> findAllOnSale(){
        return productRepository.findAllOnSale();
    }

    // TODO: TEST
    public List<Product> findAllActivesOnSale(){
        return productRepository.findAllActivesOnSale();
    }

    // TODO: TEST
    public List<Product> findAllNotOnSale(){
        return productRepository.findAllNotOnSale();
    }

    // TODO: TEST
    public List<Product> findAllActivesNotOnSale(){
        return productRepository.findAllActivesNotOnSale();
    }

    // TODO: TEST
    public List<Product> findAllByCollection(@NotNull Long idCollection){
        return productRepository.findAllByCollection(idCollection);
    }

    // TODO: TEST
    public List<Product> findAllActivesByCollection(@NotNull Long idCollection){
        return productRepository.findAllActivesByCollection(idCollection);
    }

    // TODO: TEST
    public List<Product> findAllInStock(){
        return productRepository.findAllInStock();
    }

    // TODO: TEST
    public List<Product> findAllActivesInStock(){
        return productRepository.findAllActivesInStock();
    }

    // TODO: TEST
    public List<Product> findAllNotInStock(){
        return productRepository.findAllNotInStock();
    }

    // TODO: TEST
    public List<Product> findAllByCategory(@NotNull Long idCategory){
        return productRepository.findAllByCategory(idCategory);
    }

    // TODO: TEST
    public List<Product> findAllActivesByCategory(@NotNull Long idCategory){
        return productRepository.findAllActivesByCategory(idCategory);
    }

    // TODO: TEST
    public List<Product> findAllByTitle(@NotNull String partialTitle){
        return productRepository.findAllByTitle(partialTitle.trim().toLowerCase());
    }

    // TODO: TEST
    public List<Product> findAllActivesByTitle(@NotNull String partialTitle){
        return productRepository.findAllActivesByTitle(partialTitle.trim().toLowerCase());
    }

//    public List<Product> findAllActivesByPriceRange(@NotNull BigDecimal minPrice, @NotNull BigDecimal maxPrice){
//        return productRepository.findAllActivesByPriceRange(minPrice, maxPrice);
//    }



    // TODO: TEST
    public boolean unlinkProductFromBrandById(@NotNull Long idBrand){
        List<Product> productList = this.findAllByBrand(idBrand);
        for (Product product : productList){
            product.setBrand(null);
            this.update(product);
        }
        return true;
    }

    // TODO: TEST
    public boolean updateRanking(@NotNull Long id){
        Product entity = this.findById(id);
        if(entity != null){
            if(entity.getRating() <= 9){
                entity.setRating(entity.getRating()+1);
                this.update(entity);
            }
            return true;
        }
        else{
            return false;
        }
    }

    private void isProductSale(Product product){
        if(product.getDiscountPercentage() != null && product.getDiscountPercentage().compareTo(new BigDecimal(0)) == 1){
            product.setSale(true);
            for (Variant variant : product.getVariants()){
                variant.setTotalPriceAmount(currencyCLP.applyDiscount(variant.getBasePriceAmount(), product.getDiscountPercentage()));
            }
        }
        else{
            product.setSale(false);
            product.setDiscountPercentage(null);
            for (Variant variant : product.getVariants()){
                variant.setTotalPriceAmount(variant.getBasePriceAmount());
            }
        }
    }


}
