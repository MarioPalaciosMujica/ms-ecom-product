package com.ecom.product.service;

import com.ecom.product.dalc.repositories.IVariantRepository;
import com.ecom.product.tools.CurrencyCLP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class VariantService {

    @Autowired private IVariantRepository variantRepository;
    @Autowired private CurrencyCLP currencyCLP;

    public void deleteById(@NotNull Long id){
        variantRepository.deleteById(id);
    }
}
