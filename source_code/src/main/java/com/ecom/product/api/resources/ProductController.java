package com.ecom.product.api.resources;

import com.ecom.product.api.mapping.ProductMap;
import com.ecom.product.api.mapping.TagMap;
import com.ecom.product.api.models.ProductModel;
import com.ecom.product.api.models.TagModel;
import com.ecom.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/Product")
public class ProductController {

    @Autowired private ProductService productService;
    @Autowired private ProductMap productMap;
    @Autowired private TagMap tagMap;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody @NotNull ProductModel model){
        productService.save(productMap.toEntity(model));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<ProductModel> findAll(){
        return productMap.toModelList(productService.findAll());
    }

    @RequestMapping(value = "/findAllActives", method = RequestMethod.GET)
    public List<ProductModel> findAllActives(){
        return productMap.toModelList(productService.findAllActives());
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public ProductModel findById(@PathVariable @NotNull Long id){
        return productMap.toModel(productService.findById(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void update(@RequestBody @NotNull ProductModel model){
        productService.update(productMap.toEntity(model));
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable @NotNull Long id){
        productService.deleteById(id);
    }

    @RequestMapping(value = "/findAllByTag/{idTag}", method = RequestMethod.GET)
    public List<ProductModel> findAllByTag(@PathVariable @NotNull Long idTag){
        return productMap.toModelList(productService.findAllByTag(idTag));
    }

    @RequestMapping(value = "/findAllActivesByTag/{idTag}", method = RequestMethod.GET)
    public List<ProductModel> findAllActivesByTag(@PathVariable @NotNull Long idTag){
        return productMap.toModelList(productService.findAllActivesByTag(idTag));
    }

    // POST method only used because Body parameter, but this is a GET call in practice.
    @RequestMapping(value = "/findAllByTags", method = RequestMethod.POST)
    public List<ProductModel> findAllByTags(@RequestBody @NotNull List<TagModel> tagList){
        return productMap.toModelList(productService.findAllByTags(tagMap.toEntityList(tagList)));
    }

    // POST method only used because Body parameter, but this is a GET call in practice.
    @RequestMapping(value = "/findAllActivesByTags", method = RequestMethod.POST)
    public List<ProductModel> findAllActivesByTags(@RequestBody @NotNull List<TagModel> tagList){
        return productMap.toModelList(productService.findAllActivesByTags(tagMap.toEntityList(tagList)));
    }

    @RequestMapping(value = "/findAllNew", method = RequestMethod.GET)
    public List<ProductModel> findAllNew(){
        return productMap.toModelList(productService.findAllNew());
    }

    @RequestMapping(value = "/findAllActivesNew", method = RequestMethod.GET)
    public List<ProductModel> findAllActivesNew(){
        return productMap.toModelList(productService.findAllActivesNew());
    }

    @RequestMapping(value = "/findAllNotNew", method = RequestMethod.GET)
    public List<ProductModel> findAllNotNew(){
        return productMap.toModelList(productService.findAllNotNew());
    }

    @RequestMapping(value = "/findAllActivesNotNew", method = RequestMethod.GET)
    public List<ProductModel> findAllActivesNotNew(){
        return productMap.toModelList(productService.findAllActivesNotNew());
    }

    @RequestMapping(value = "/findAllOnSale", method = RequestMethod.GET)
    public List<ProductModel> findAllOnSale(){
        return productMap.toModelList(productService.findAllOnSale());
    }

    @RequestMapping(value = "/findAllActivesOnSale", method = RequestMethod.GET)
    public List<ProductModel> findAllActivesOnSale(){
        return productMap.toModelList(productService.findAllActivesOnSale());
    }

    @RequestMapping(value = "/findAllNotOnSale", method = RequestMethod.GET)
    public List<ProductModel> findAllNotOnSale(){
        return productMap.toModelList(productService.findAllNotOnSale());
    }

    @RequestMapping(value = "/findAllActivesNotOnSale", method = RequestMethod.GET)
    public List<ProductModel> findAllActivesNotOnSale(){
        return productMap.toModelList(productService.findAllActivesNotOnSale());
    }

    @RequestMapping(value = "/findAllByCollection", method = RequestMethod.GET)
    public List<ProductModel> findAllByCollection(@PathVariable @NotNull Long idCollection){
        return productMap.toModelList(productService.findAllByCollection(idCollection));
    }

    @RequestMapping(value = "/findAllActivesByCollection", method = RequestMethod.GET)
    public List<ProductModel> findAllActivesByCollection(@PathVariable @NotNull Long idCollection){
        return productMap.toModelList(productService.findAllActivesByCollection(idCollection));
    }

    @RequestMapping(value = "/findAllInStock", method = RequestMethod.GET)
    public List<ProductModel> findAllInStock(){
        return productMap.toModelList(productService.findAllInStock());
    }

    @RequestMapping(value = "/findAllActivesInStock", method = RequestMethod.GET)
    public List<ProductModel> findAllActivesInStock(){
        return productMap.toModelList(productService.findAllActivesInStock());
    }

    @RequestMapping(value = "/findAllNotInStock", method = RequestMethod.GET)
    public List<ProductModel> findAllNotInStock(){
        return productMap.toModelList(productService.findAllNotInStock());
    }

    @RequestMapping(value = "/findAllByCategory/{idCategory}", method = RequestMethod.GET)
    public List<ProductModel> findAllByCategory(@PathVariable @NotNull Long idCategory){
        return productMap.toModelList(productService.findAllByCategory(idCategory));
    }

    @RequestMapping(value = "/findAllActivesByCategory/{idCategory}", method = RequestMethod.GET)
    public List<ProductModel> findAllActivesByCategory(@PathVariable @NotNull Long idCategory){
        return productMap.toModelList(productService.findAllActivesByCategory(idCategory));
    }

    @RequestMapping(value = "/findAllByBrand/{idTag}", method = RequestMethod.GET)
    public List<ProductModel> findAllByBrand(@PathVariable @NotNull Long idBrand){
        return productMap.toModelList(productService.findAllByBrand(idBrand));
    }

    @RequestMapping(value = "/findAllActivesByBrand/{idTag}", method = RequestMethod.GET)
    public List<ProductModel> findAllActivesByBrand(@PathVariable @NotNull Long idBrand){
        return productMap.toModelList(productService.findAllActivesByBrand(idBrand));
    }

    @RequestMapping(value = "/findAllByTitle/{partialTitle}", method = RequestMethod.GET)
    public List<ProductModel> findAllByTitle(@PathVariable @NotNull String partialTitle){
        return productMap.toModelList(productService.findAllByTitle(partialTitle));
    }

    @RequestMapping(value = "/findAllActivesByTitle/{partialTitle}", method = RequestMethod.GET)
    public List<ProductModel> findAllActivesByTitle(@PathVariable @NotNull String partialTitle){
        return productMap.toModelList(productService.findAllActivesByTitle(partialTitle));
    }

    @RequestMapping(value = "/findAllActivesByPriceRange/{minPrice}/{maxPrice}", method = RequestMethod.GET)
    public List<ProductModel> findAllActivesByPriceRange(@PathVariable @NotNull BigDecimal minPrice, @PathVariable @NotNull BigDecimal maxPrice){
        return productMap.toModelList(productService.findAllActivesByPriceRange(minPrice, maxPrice));
    }

    @RequestMapping(value = "/updateRanking/{id}", method = RequestMethod.PATCH)
    public void updateRanking(@PathVariable @NotNull Long id){
        productService.updateRanking(id);
    }

}
