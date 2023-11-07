package com.ProdOrder.ProdOrders.controller;



import com.ProdOrder.ProdOrders.entity.Order;
//import com.ProdOrder.ProdOrders.entity.order;
import com.ProdOrder.ProdOrders.service.orderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class orderController {

    private final orderService orser;

    @PostMapping("/saveOrUPdateOrders")
    public Order saveOrUpdateProd(@RequestBody Order prod){
        orser.saveOrUpdate(prod);
        return prod;
    }

    @DeleteMapping("/deleteOrder/{orderId}")
    public ResponseEntity<String> deleteProd(@PathVariable(value = "orderId" , required = true)String orderId){
        orser.deleteOrder(Integer.parseInt(orderId));
        return new ResponseEntity<>("orderis deleted",HttpStatus.OK);
    }
    @GetMapping("/getAllOrders")
    public List<Order> getAllOrders(){
        return  orser.getAllOrder();
//        return null;
    }
    @GetMapping("/getOneOrder")
    public ResponseEntity<Order> getByIdProd(@RequestParam("orderId") String orderId){
        Order prod = orser.getOrder(Integer.parseInt(orderId));
        return new ResponseEntity<Order>(prod,HttpStatus.OK);
//        return null;
    }



}
