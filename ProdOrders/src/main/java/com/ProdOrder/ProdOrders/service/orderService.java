package com.ProdOrder.ProdOrders.service;

import com.ProdOrder.ProdOrders.entity.Order;

import com.ProdOrder.ProdOrders.dao.orderDao;
import com.ProdOrder.ProdOrders.dao.productDao;
import com.ProdOrder.ProdOrders.entity.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class orderService {

//    Logger log = Logger.getLogger(productService.class);

    private final orderDao orDao;
    public void saveOrUpdate(Order order){
        log.info("Inserting Product object");
        prDao.save(order);
    }

    public List<Order> getAllOrder(){
        log.info("Finding all Products");
        return orDao.findAll();
    }

    public Order getOrder(Integer id){
        log.info("Finding product with specific id-{}",id);
        return orDao.findById(id).orElse(null);

//        Optional<Product> pr = prDao.findById(id);
//        if(pr.isPresent()){
//            Product p =pr.get();
//            return p;
//        }
//        throw new RuntimeException("Product not present with"+id);
    }

    public void deleteOrder(int orderId){
        log.info("Deleting product object by product id");
        orDao.deleteById(orderId);
    }
}

