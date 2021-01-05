package com.devsuperior.dsdeliver.dto;

import com.devsuperior.dsdeliver.enteties.Order;
import com.devsuperior.dsdeliver.enteties.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Long id;

    private String address;

    private Double latitude;

    private Double longitude;

    private Instant moment;

    private OrderStatus status;

    private List<ProductDTO> products = new ArrayList<>();


    public OrderDTO(Order entity) {
        id = entity.getId();
        address = entity.getAddress();
        latitude = entity.getLatitude();
        longitude = entity.getLongitude();
        moment = entity.getMoment();
        status = entity.getStatus();
        products = entity.getProducts().stream()
                .map(product -> new ProductDTO(product)).collect(Collectors.toList());
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}