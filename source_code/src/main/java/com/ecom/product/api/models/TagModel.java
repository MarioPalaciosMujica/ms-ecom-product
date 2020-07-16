package com.ecom.product.api.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class TagModel {

    private Long idTag;
    private String name;
    private boolean isActive;
    private Date created;
    private Date modified;
}
