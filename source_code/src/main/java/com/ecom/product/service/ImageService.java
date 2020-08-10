package com.ecom.product.service;

import com.ecom.product.config.AppConfig;
import com.ecom.product.dalc.entities.Image;
import com.ecom.product.dalc.repositories.IImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired private IImageRepository imageRepository;
    @Autowired private AppConfig appConfig;
    @Autowired private AmazonClientService amazonClientService;

    public Image save(@NotNull Image entity){
        entity.setIdImage(null);
        entity.setCreated(new Date());
        entity.setModified(null);
        imageRepository.save(entity);
        return entity;
    }

    public void saveAll(@NotNull List<Image> imageList){
        for (Image img : imageList){
            this.save(img);
        }
    }

    public Image findById(@NotNull Long id){
        Optional<Image> entity = imageRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else {
            return null;
        }
    }

    public List<Image> findAll(){
        return imageRepository.findAll();
    }

    public boolean update(@NotNull Image entity){
        entity.setModified(new Date());
        imageRepository.save(entity);
        return true;
    }

    public boolean deleteById(@NotNull Long id){
        if(this.findById(id) != null){
            imageRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }

    // DEV-ENV
    public Image uploadImage(MultipartFile imageFile) throws Exception{
        String folder = appConfig.getImageSourceFolder();
        File dir = new File(folder);
        if(!dir.exists()){
            dir.mkdirs();
        }
        Path path = Paths.get(folder + imageFile.getOriginalFilename());
        byte[] bytes = imageFile.getBytes();
        Files.write(path, bytes);

        Image entity = new Image();
        entity.setSrc(folder + imageFile.getOriginalFilename());
        return this.save(entity);
    }

    // PROD-ENV
//    public Image uploadImage(MultipartFile imageFile){
//        String imageUrl = this.amazonClientService.uploadFile(imageFile);
//        String imageName = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);
//
//        Image entity = new Image();
//        entity.setSrc(imageUrl);
//        return this.save(entity);
//    }
//
//    public void deleteById(@NotNull Long id){
//        Image image = this.findById(id);
//        if(image != null){
//            this.amazonClientService.deleteFileFromS3Bucket(image.getUrlImage());
//        }
//        imageRepository.deleteById(id);
//    }
}
