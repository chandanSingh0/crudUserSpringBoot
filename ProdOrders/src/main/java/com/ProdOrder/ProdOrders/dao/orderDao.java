package com.ProdOrder.ProdOrders.dao;

import com.ProdOrder.ProdOrders.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface orderDao extends JpaRepository<Order,Integer> {

}
