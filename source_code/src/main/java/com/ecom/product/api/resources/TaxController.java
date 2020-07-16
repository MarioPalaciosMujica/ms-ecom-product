package com.ecom.product.api.resources;

import com.ecom.product.api.mapping.ProductTaxMap;
import com.ecom.product.api.models.ProductTaxModel;
import com.ecom.product.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/ProductTax")
public class TaxController {

    @Autowired private TaxService taxService;
    @Autowired private ProductTaxMap productTaxMap;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody @NotNull ProductTaxModel model){
        taxService.save(productTaxMap.toEntity(model));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<ProductTaxModel> findAll(){
        return productTaxMap.toModelList(taxService.findAll());
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public ProductTaxModel findById(@PathVariable @NotNull Long id){
        return productTaxMap.toModel(taxService.findById(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void update(@RequestBody @NotNull ProductTaxModel model){
        taxService.update(productTaxMap.toEntity(model));
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable @NotNull Long id){
        taxService.deleteById(id);
    }
}
