package com.ecom.product.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;

@Component
@ConfigurationProperties
@PropertySource("application.properties")
public class AppConfig {

    @NotEmpty
    @Value("${image.sourcefolder}")
    private String imageSourceFolder;

    @NotEmpty
    @Value("${image.path}")
    private String imagePartialPath;


    public String getImageSourceFolder() {
        return imageSourceFolder;
    }

    public String getImagePartialPath() {
        return imagePartialPath;
    }
}
