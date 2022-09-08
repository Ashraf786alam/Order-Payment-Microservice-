package com.example.order.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.order.Entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {

}
