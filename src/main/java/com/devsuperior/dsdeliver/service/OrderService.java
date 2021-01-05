package com.devsuperior.dsdeliver.service;

import com.devsuperior.dsdeliver.dto.OrderDTO;
import com.devsuperior.dsdeliver.dto.ProductDTO;
import com.devsuperior.dsdeliver.enteties.Order;
import com.devsuperior.dsdeliver.enteties.OrderStatus;
import com.devsuperior.dsdeliver.enteties.Product;
import com.devsuperior.dsdeliver.exceptions.errors.OrderNotFoundException;
import com.devsuperior.dsdeliver.mapper.OrderMapper;
import com.devsuperior.dsdeliver.repositories.OrderRepository;
import com.devsuperior.dsdeliver.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    private final OrderMapper orderMapper = OrderMapper.INSTANCE;


    @Transactional(readOnly = true)
    public List<OrderDTO> findAll() {
        List<Order> allOrder = orderRepository.findAllByIdAndMoment();
        return allOrder.stream().map(orderMapper::toDTO).collect(Collectors.toList());
    }

    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        Order order = new Order(null,
                orderDTO.getAddress(),
                orderDTO.getLatitude(),
                orderDTO.getLongitude(),
                Instant.now(), OrderStatus.PENDING);
        for (ProductDTO p : orderDTO.getProducts()) {
            Product product = productRepository.getOne(p.getId());
            order.getProducts().add(product);
        }
        order = orderRepository.save(order);
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO setDelivered(Long id) throws OrderNotFoundException {
        verifyIdExist(id);
        Order order = orderRepository.getOne(id);
        order.setStatus(OrderStatus.DELIVERED);
        order = orderRepository.save(order);
        return new OrderDTO(order);

    }

    private Order verifyIdExist(Long id) throws OrderNotFoundException {
        return orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException("Id " + id + " não localizado"));
    }
}
