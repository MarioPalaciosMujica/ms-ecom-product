package com.ecom.product.service;

import com.ecom.product.dalc.entities.UnitNumber;
import com.ecom.product.dalc.repositories.IUnitNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
public class UnitNumberService {

    @Autowired private IUnitNumberRepository unitNumberRepository;

    public UnitNumber save(@NotNull UnitNumber entity){
        entity.setIdUnitNumber(null);
        unitNumberRepository.save(entity);
        return entity;
    }

    public UnitNumber findById(@NotNull Long id){
        Optional<UnitNumber> entity = unitNumberRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else {
            return null;
        }
    }

    public List<UnitNumber> findAll(){
        return unitNumberRepository.findAll();
    }

    public boolean update(@NotNull UnitNumber entity){
        UnitNumber original = this.findById(entity.getIdUnitNumber());
        if(original != null){
            unitNumberRepository.save(entity);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean deleteById(@NotNull Long id){
        if(this.findById(id) != null){
            unitNumberRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }
}
