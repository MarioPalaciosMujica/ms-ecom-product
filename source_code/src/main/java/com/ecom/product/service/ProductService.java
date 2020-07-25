package com.ecom.product.service;

import com.ecom.product.dalc.entities.Collection;
import com.ecom.product.dalc.entities.Product;
import com.ecom.product.dalc.repositories.IProductRepository;
import com.ecom.product.tools.CurrencyCLP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired private IProductRepository productRepository;
    @Autowired private CollectionService collectionService;
    @Autowired private CurrencyCLP currencyCLP;

    public Product save(@NotNull Product entity){
        entity.setIdProduct(null);
        entity.setPrice(currencyCLP.roundClp(entity.getPrice()));
        this.isProductSale(entity);
        entity.setNew(true);
        entity.setRating(0);
        entity.setCreated(new Date());
        entity.setModified(null);
        return productRepository.save(entity);
    }

    public Product findById(@NotNull Long id){
        Optional<Product> entity = productRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else{
            return null;
        }
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public boolean update(@NotNull Product entity){
        Product original = this.findById(entity.getIdProduct());
        if(original != null){
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

    public List<Product> findAllActives(){
        return productRepository.findAllActives();
    }

    public List<Product> findAllByTag(@NotNull Long idTag){
        return productRepository.findAllByTag(idTag);
    }

    public List<Product> findAllActivesByTag(@NotNull Long idTag){
        return productRepository.findAllActivesByTag(idTag);
    }

    public List<Product> findAllByBrand(@NotNull Long idBrand){
        return productRepository.findAllByBrand(idBrand);
    }

    public List<Product> findAllActivesByBrand(@NotNull Long idTag){
        return productRepository.findAllActivesByBrand(idTag);
    }

    public List<Product> findAllNew(){
        return productRepository.findAllNew();
    }

    public List<Product> findAllActivesNew(){
        return productRepository.findAllActivesNew();
    }

    public List<Product> findAllNotNew(){
        return productRepository.findAllNotNew();
    }

    public List<Product> findAllActivesNotNew(){
        return productRepository.findAllActivesNotNew();
    }

    public List<Product> findAllOnSale(){
        return productRepository.findAllOnSale();
    }

    public List<Product> findAllActivesOnSale(){
        return productRepository.findAllActivesOnSale();
    }

    public List<Product> findAllNotOnSale(){
        return productRepository.findAllNotOnSale();
    }

    public List<Product> findAllActivesNotOnSale(){
        return productRepository.findAllActivesNotOnSale();
    }

    public List<Product> findAllByCollection(@NotNull Long idCollection){
        return productRepository.findAllByCollection(idCollection);
    }

    public List<Product> findAllActivesByCollection(@NotNull Long idCollection){
        return productRepository.findAllActivesByCollection(idCollection);
    }

    public List<Product> findAllInStock(){
        return productRepository.findAllInStock();
    }

    public List<Product> findAllActivesInStock(){
        return productRepository.findAllActivesInStock();
    }

    public List<Product> findAllNotInStock(){
        return productRepository.findAllNotInStock();
    }

    public List<Product> findAllByCategory(@NotNull Long idCategory){
        return productRepository.findAllByCategory(idCategory);
    }

    public List<Product> findAllActivesByCategory(@NotNull Long idCategory){
        return productRepository.findAllActivesByCategory(idCategory);
    }

    public List<Product> findAllByTitle(@NotNull String partialTitle){
        return productRepository.findAllByTitle(partialTitle.trim().toLowerCase());
    }

    public List<Product> findAllActivesByTitle(@NotNull String partialTitle){
        return productRepository.findAllActivesByTitle(partialTitle.trim().toLowerCase());
    }

    public List<Product> findAllActivesByPriceRange(@NotNull BigDecimal minPrice, @NotNull BigDecimal maxPrice){
        return productRepository.findAllActivesByPriceRange(minPrice, maxPrice);
    }

    public boolean unlinkProductFromBrandById(@NotNull Long idBrand){
        List<Product> productList = this.findAllByBrand(idBrand);
        for (Product product : productList){
            product.setBrand(null);
            this.update(product);
        }
        return true;
    }

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
            product.setPriceDiscount(currencyCLP.applyDiscount(product.getPrice(), product.getDiscountPercentage()));
        }
        else{
            product.setSale(false);
            product.setDiscountPercentage(null);
            product.setPriceDiscount(null);
        }
    }
}
