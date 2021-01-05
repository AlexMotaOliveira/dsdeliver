package com.devsuperior.dsdeliver.enteties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "tb_product")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(nullable = false,length = 60)
    private String name;

    @NotEmpty
    @Column(nullable = false,length = 10)
    private Double price;

    @NotEmpty
    @Column(nullable = false,length = 300)
    private String description;

    @NotEmpty
    @Column(nullable = false,length = 300)
    private String imageUri;
}