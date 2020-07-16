package com.ecom.product.api.resources;

import com.ecom.product.api.mapping.ProductMap;
import com.ecom.product.api.models.ProductModel;
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

    @RequestMapping(value = "/findAllByCategory/{idCategory}", method = RequestMethod.GET)
    public List<ProductModel> findAllByCategory(@PathVariable @NotNull Long idCategory){
        return productMap.toModelList(productService.findAllByCategory(idCategory));
    }

    @RequestMapping(value = "/findAllActivesByCategory/{idCategory}", method = RequestMethod.GET)
    public List<ProductModel> findAllActivesByCategory(@PathVariable @NotNull Long idCategory){
        return productMap.toModelList(productService.findAllActivesByCategory(idCategory));
    }

    @RequestMapping(value = "/findAllByFeatureType/{idFeatureType}", method = RequestMethod.GET)
    public List<ProductModel> findAllByFeatureType(@PathVariable @NotNull Long idFeatureType){
        return productMap.toModelList(productService.findAllByFeatureType(idFeatureType));
    }

    @RequestMapping(value = "/findAllActivesByFeatureType/{idFeatureType}", method = RequestMethod.GET)
    public List<ProductModel> findAllActivesByFeatureType(@PathVariable @NotNull Long idFeatureType){
        return productMap.toModelList(productService.findAllActivesByFeatureType(idFeatureType));
    }

    @RequestMapping(value = "/findAllByBrand/{idTag}", method = RequestMethod.GET)
    public List<ProductModel> findAllByBrand(@PathVariable @NotNull Long idBrand){
        return productMap.toModelList(productService.findAllByBrand(idBrand));
    }

    @RequestMapping(value = "/findAllActivesByBrand/{idTag}", method = RequestMethod.GET)
    public List<ProductModel> findAllActivesByBrand(@PathVariable @NotNull Long idBrand){
        return productMap.toModelList(productService.findAllActivesByBrand(idBrand));
    }

    @RequestMapping(value = "/findAllByDiscount/{idTag}", method = RequestMethod.GET)
    public List<ProductModel> findAllByDiscount(@PathVariable @NotNull Long idDiscount){
        return productMap.toModelList(productService.findAllByDiscount(idDiscount));
    }

    @RequestMapping(value = "/findAllActivesByDiscount/{idTag}", method = RequestMethod.GET)
    public List<ProductModel> findAllActivesByDiscount(@PathVariable @NotNull Long idDiscount){
        return productMap.toModelList(productService.findAllActivesByDiscount(idDiscount));
    }

    @RequestMapping(value = "/findAllByNameLike/{partialName}", method = RequestMethod.GET)
    public List<ProductModel> findAllByNameLike(@PathVariable @NotNull String partialName){
        return productMap.toModelList(productService.findAllByNameLike(partialName));
    }

    @RequestMapping(value = "/findAllByPriceRange/{minPrice}/{maxPrice}", method = RequestMethod.GET)
    public List<ProductModel> findAllByPriceRange(@PathVariable @NotNull BigDecimal minPrice, @PathVariable @NotNull BigDecimal maxPrice){
        return productMap.toModelList(productService.findAllByPriceRange(minPrice, maxPrice));
    }

    @RequestMapping(value = "/updateRanking/{id}", method = RequestMethod.PATCH)
    public void addRanking(@PathVariable @NotNull Long id){
        productService.updateRanking(id);
    }
}
