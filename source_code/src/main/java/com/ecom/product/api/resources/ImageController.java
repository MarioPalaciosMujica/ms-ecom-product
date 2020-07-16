package com.ecom.product.api.resources;

import com.ecom.product.api.mapping.ImageMap;
import com.ecom.product.api.models.ImageModel;
import com.ecom.product.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/Image")
public class ImageController {

    @Autowired private ImageService imageService;
    @Autowired private ImageMap imageMap;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody @NotNull ImageModel model){
        imageService.save(imageMap.toEntity(model));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<ImageModel> findAll(){
        return imageMap.toModelList(imageService.findAll());
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public ImageModel findById(@PathVariable @NotNull Long id){
        return imageMap.toModel(imageService.findById(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void update(@RequestBody @NotNull ImageModel model){
        imageService.update(imageMap.toEntity(model));
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable @NotNull Long id){
        imageService.deleteById(id);
    }

    @RequestMapping(path = "/uploadImage", method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public void uploadImage(@RequestParam("image") MultipartFile imageFile) {
        ImageModel model = null;
        try{
            model = imageMap.toModel(imageService.uploadImage(imageFile));
        }
        catch (Exception ex){
            System.out.println("IMAGE UPLOAD ERROR: " + ex.toString());
        }
    }

}
