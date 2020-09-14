package com.ecom.product.api.resources;

import com.ecom.product.api.mapping.VariantMap;
import com.ecom.product.service.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/Variant")
public class VariantController {

    @Autowired private VariantService variantService;
    @Autowired private VariantMap variantMap;

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable @NotNull Long id){
        variantService.deleteById(id);
    }
}
