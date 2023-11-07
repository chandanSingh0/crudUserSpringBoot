package com.example.demo.controller;

import com.example.demo.entity.Products;
import com.example.demo.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/prod")
public class productController {

    @Autowired
    private productService pser;

    @GetMapping("/findAll")
    public ResponseEntity<?> getAllProducts(){
        Page<Products> prods = pser.findAllProdPageable();

        Map<String,Object> res = new HashMap<>();
        res.put("products", prods.getContent());
        res.put("curPage",prods.getNumber());
        res.put("totItems",prods.getTotalElements());
        res.put("totPages", prods.getTotalPages());



        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/findAllDist")
    public ResponseEntity<List<String>> getAllProductsDist(){
        return new ResponseEntity<>(pser.findAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Products> findBYId(@PathVariable Long id){
        return new ResponseEntity<>(pser.findById(id),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Products> createPro(@RequestBody Products pro){
        return ResponseEntity.ok().body(pser.createProd(pro));
    }
    @PutMapping("/update")
    public ResponseEntity<Products> updatePro(@RequestBody Products pro){
        return ResponseEntity.ok().body(pser.updProduct(pro));
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus delPro(@PathVariable Long id){
        pser.delProductById(id);
        return HttpStatus.OK;
    }






}
