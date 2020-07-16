package com.ecom.product.api.resources;

import com.ecom.product.api.mapping.ProductDiscountMap;
import com.ecom.product.api.models.ProductDiscountModel;
import com.ecom.product.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/ProductDiscount")
public class DiscountController {

    @Autowired private DiscountService discountService;
    @Autowired private ProductDiscountMap productDiscountMap;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody @NotNull ProductDiscountModel model){
        discountService.save(productDiscountMap.toEntity(model));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<ProductDiscountModel> findAll(){
        return productDiscountMap.toModelList(discountService.findAll());
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public ProductDiscountModel findById(@PathVariable @NotNull Long id){
        return productDiscountMap.toModel(discountService.findById(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void update(@RequestBody @NotNull ProductDiscountModel model){
        discountService.update(productDiscountMap.toEntity(model));
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable @NotNull Long id){
        discountService.deleteById(id);
    }
}
