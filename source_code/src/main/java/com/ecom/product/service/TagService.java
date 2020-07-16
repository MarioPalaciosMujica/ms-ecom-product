package com.ecom.product.service;

import com.ecom.product.dalc.entities.Tag;
import com.ecom.product.dalc.repositories.ITagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    @Autowired private ITagRepository tagRepository;

    public Tag save(@NotNull Tag entity){
        entity.setIdTag(null);
        entity.setCreated(new Date());
        entity.setModified(null);
        tagRepository.save(entity);
        return entity;
    }

    public Tag findById(@NotNull Long id){
        Optional<Tag> entity = tagRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else{
            return null;
        }
    }

    public List<Tag> findAll(){
        return tagRepository.findAll();
    }

    public boolean update(@NotNull Tag entity){
        entity.setModified(new Date());
        tagRepository.save(entity);
        return true;
    }

    public boolean deleteById(@NotNull Long id){
        if(this.findById(id) != null){
            tagRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

}
