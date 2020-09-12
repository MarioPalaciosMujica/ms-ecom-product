package com.ecom.product.service;

import com.ecom.product.dalc.entities.Option;
import com.ecom.product.dalc.repositories.IOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
public class OptionService {

    @Autowired private IOptionRepository optionRepository;

    public Option save(@NotNull Option entity){
        entity.setIdOption(null);
        optionRepository.save(entity);
        return entity;
    }

    public Option findById(@NotNull Long id){
        Optional<Option> entity = optionRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else {
            return null;
        }
    }

    public List<Option> findAll(){
        return optionRepository.findAll();
    }

    public boolean update(@NotNull Option entity){
        Option original = this.findById(entity.getIdOption());
        if(original != null){
            optionRepository.save(entity);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean deleteById(@NotNull Long id){
        if(this.findById(id) != null){
            optionRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }
}
