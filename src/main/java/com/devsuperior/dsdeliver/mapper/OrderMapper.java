package com.devsuperior.dsdeliver.mapper;

import com.devsuperior.dsdeliver.dto.OrderDTO;
import com.devsuperior.dsdeliver.dto.ProductDTO;
import com.devsuperior.dsdeliver.enteties.Order;
import com.devsuperior.dsdeliver.enteties.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order toModel(OrderDTO orderDTO);

    OrderDTO toDTO(Order order);
}
