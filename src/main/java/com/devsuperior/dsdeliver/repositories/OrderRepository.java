package com.devsuperior.dsdeliver.repositories;

import com.devsuperior.dsdeliver.enteties.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select distinct obj from Order obj JOIN FETCH obj.products " +
            "where obj.status =0 order by obj.moment ASC ")
    List<Order> findAllByIdAndMoment();
}
