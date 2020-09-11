package com.ecom.product.dalc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuSection {

    private String title;
    private String type;
    private boolean active;
    private List<MenuItem> children;
}
