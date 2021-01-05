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

    @NotEmpty
    @Size(min = 1, max = 60)
    private String name;

    @NotEmpty
    @Size(min = 1, max = 10)
    private Double price;

    @NotEmpty
    @Size(min = 1, max = 300)
    private String description;

    @NotEmpty
    @Size(min = 1, max = 300)
    private String imageUri;

    public ProductDTO(Product entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.price = entity.getPrice();
        this.description = entity.getDescription();
        this.imageUri = entity.getImageUri();
    }
}