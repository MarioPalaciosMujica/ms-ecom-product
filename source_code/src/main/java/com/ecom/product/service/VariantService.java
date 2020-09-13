package com.ecom.product.service;

import com.ecom.product.dalc.entities.Variant;
import com.ecom.product.dalc.repositories.IVariantRepository;
import com.ecom.product.tools.CurrencyCLP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
//import java.util.Date;
//import java.util.List;
import java.util.Optional;

@Service
public class VariantService {

    @Autowired private IVariantRepository variantRepository;
    @Autowired private CurrencyCLP currencyCLP;

//    public Variant save(@NotNull Variant entity){
//        entity.setIdVariant(null);
//        if(entity.getSku() != null && entity.getSku() <= 0){
//            entity.setSku(null);
//        }
//        entity.setBasePriceAmount(currencyCLP.roundClp(entity.getBasePriceAmount()));
//        entity.setCreated(new Date());
//        entity.setModified(null);
//        variantRepository.save(entity);
//        return entity;
//    }

    // TODO: TEST
    public Variant findById(@NotNull Long id){
        Optional<Variant> entity = variantRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else {
            return null;
        }
    }

//    public List<Variant> findAll(){
//        return variantRepository.findAll();
//    }

//    public boolean update(@NotNull Variant entity){
//        Variant original = this.findById(entity.getIdVariant());
//        if(original != null){
//            if(entity.getSku() != null && entity.getSku() <= 0){
//                entity.setSku(null);
//            }
//            entity.setBasePriceAmount(currencyCLP.roundClp(entity.getBasePriceAmount()));
//            entity.setCreated(original.getCreated());
//            entity.setModified(new Date());
//            variantRepository.save(entity);
//            return true;
//        }
//        else{
//            return false;
//        }
//    }

    // TODO: TEST
    public boolean deleteById(@NotNull Long id){
        if(this.findById(id) != null){
            variantRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }
}
