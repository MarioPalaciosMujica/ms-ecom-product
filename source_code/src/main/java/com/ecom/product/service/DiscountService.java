package com.ecom.product.service;

import com.ecom.product.dalc.entities.Discount;
import com.ecom.product.dalc.repositories.IDiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DiscountService {

    @Autowired private IDiscountRepository discountRepository;
    @Autowired private ProductService productService;

    public Discount save(@NotNull Discount entity){
        entity.setIdDiscount(null);
        entity.setCreated(new Date());
        entity.setModified(null);
        discountRepository.save(entity);
        return entity;
    }

    public Discount findById(@NotNull Long id){
        Optional<Discount> entity = discountRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else {
            return null;
        }
    }

    public List<Discount> findAll(){
        return discountRepository.findAll();
    }

    public boolean update(@NotNull Discount entity){
        Discount original = this.findById(entity.getIdDiscount());
        if(original != null){
            entity.setCreated(original.getCreated());
            entity.setModified(new Date());
            discountRepository.save(entity);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean deleteById(@NotNull Long id){
        if(this.findById(id) != null){
            discountRepository.deleteById(id);
            productService.unlinkProductFromDiscountById(id);
            return true;
        }
        else {
            return false;
        }
    }
}
