package com.ideas2it.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideas2it.onlinestore.model.OrderList;

public interface OrderRepository extends JpaRepository<OrderList, Integer>{

}
