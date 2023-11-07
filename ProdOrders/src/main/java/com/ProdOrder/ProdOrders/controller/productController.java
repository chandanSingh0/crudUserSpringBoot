package com.ProdOrder.ProdOrders.controller;

import com.ProdOrder.ProdOrders.entity.Product;
import com.ProdOrder.ProdOrders.service.productService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class productController {

    private final productService prser;

    @PostMapping("/saveOrUPdate")
    public Product saveOrUpdateProd(@RequestBody Product prod){
        prser.saveOrUpdate(prod);
        return prod;
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<String> deleteProd(@PathVariable(value = "productId" , required = true)String productId){
        prser.deleteProd(Integer.parseInt(productId));
        return new ResponseEntity<>("Productis deleted",HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public List<Product> getAllProd(){
       return  prser.getAllProduct();
//        return null;
    }
    @GetMapping("/getOne")
    public ResponseEntity<Product> getByIdProd(@RequestParam("productId") String productId){
            Product prod = prser.getProduct(Integer.parseInt(productId));
            return new ResponseEntity<Product>(prod,HttpStatus.OK);
//        return null;
    }



}
