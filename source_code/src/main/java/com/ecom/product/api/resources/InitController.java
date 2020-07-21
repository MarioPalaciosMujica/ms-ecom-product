package com.ecom.product.api.resources;

import com.ecom.product.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Init")
public class InitController {

    @Autowired private InitService initService;

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public void start(){
        initService.start();
    }

}
