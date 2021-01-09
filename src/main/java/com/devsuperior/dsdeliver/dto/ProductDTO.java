package com.devsuperior.dsdeliver.dto;

import com.devsuperior.dsdeliver.enteties.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
public class ProductDTO implements Serializable {

    private Long id;
    private String name;
    private Double price;
    private String description;
    private String imageUri;

    public ProductDTO(Product entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.price = entity.getPrice();
        this.description = entity.getDescription();
        this.imageUri = entity.getImageUri();
    }
}