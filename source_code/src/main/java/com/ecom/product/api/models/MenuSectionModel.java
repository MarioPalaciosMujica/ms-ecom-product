package com.ecom.product.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MenuSectionModel {

    @JsonProperty("title")
    private String title;

    @JsonProperty("type")
    private String type;

    @JsonProperty("active")
    private boolean active;

    @JsonProperty("children")
    private List<MenuItemModel> children;
}
