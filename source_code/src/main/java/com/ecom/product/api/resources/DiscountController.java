package com.ecom.product.api.resources;

import com.ecom.product.api.mapping.DiscountMap;
import com.ecom.product.api.models.DiscountModel;
import com.ecom.product.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/Discount")
public class DiscountController {

    @Autowired private DiscountService discountService;
    @Autowired private DiscountMap discountMap;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody @NotNull DiscountModel model){
        discountService.save(discountMap.toEntity(model));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<DiscountModel> findAll(){
        return discountMap.toModelList(discountService.findAll());
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public DiscountModel findById(@PathVariable @NotNull Long id){
        return discountMap.toModel(discountService.findById(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void update(@RequestBody @NotNull DiscountModel model){
        discountService.update(discountMap.toEntity(model));
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable @NotNull Long id){
        discountService.deleteById(id);
    }
}
