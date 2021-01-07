package com.devsuperior.dsdeliver.enteties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_order")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(nullable = false,length = 300)
    private String address;

    @NotEmpty
    @Column(nullable = false,length = 50)
    private Double latitude;

    @NotEmpty
    @Column(nullable = false,length = 50)
    private Double longitude;

    @NotEmpty
    @Column(nullable = false,length = 20)
    private Instant moment;

    @NotEmpty
    @Column(nullable = false,length = 20)
    private OrderStatus status;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private final Set<Product> products = new HashSet<>();

}