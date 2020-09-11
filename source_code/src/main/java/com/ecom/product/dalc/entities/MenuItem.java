package com.ecom.product.dalc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuItem {

    private String path;
    private String title;
    private String type;
    private List<MenuItem> children;
}
