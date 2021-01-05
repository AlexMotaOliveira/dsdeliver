package com.devsuperior.dsdeliver.service;

import com.devsuperior.dsdeliver.dto.ProductDTO;
import com.devsuperior.dsdeliver.enteties.Product;
import com.devsuperior.dsdeliver.mapper.ProductMapper;
import com.devsuperior.dsdeliver.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    private final ProductMapper productMapper = ProductMapper.INSTANCE;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll(){
        List<Product> allproduct = productRepository.findAllByOrderByNameAsc();
        return allproduct.stream().map(productMapper::toDTO).collect(Collectors.toList());
    }
}
