package com.example.demo.service;

import com.example.demo.entity.Products;
import com.example.demo.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class productService {

    @Autowired
    private productRepository prep;

    public Products createProd(Products pro){
        return prep.save(pro);
    }

    public Products updProduct(Products prod){
        Optional<Products> p = prep.findById(prod.getId());
        if(p.isPresent()){
            Products pr = p.get();
            pr.setName(prod.getName());
            pr.setDescription(prod.getDescription());

            prep.save(pr);

            return pr;
        }
        throw new RuntimeException("Product with id"+ prod.getId() +" is not present ");
    }

    public List<Products> findAllProd(){
//       List<String> pro = Arrays.asList("Mobile Phone","sco");
        return prep.findAllByAsc();
    }
    public List<String> findAllProducts(){
//       List<String> pro = Arrays.asList("Mobile Phone","sco");
        return prep.findProdbydistDescription();
    }

    public Products findById(Long id){
        Optional<Products> p = prep.findById(id);
        if(p.isPresent()){
            Products pro = p.get();
            return pro;
        }
        throw new RuntimeException("Product with id"+ id +" is not present ");
    }

    public String delProductById(Long id){
        Optional<Products> p = prep.findById(id);
        if(p.isPresent()){
            prep.deleteById(id);
            return "Product is deleted whose id is"+ id;
        }
        throw new RuntimeException("Product is not present whose id"+id);
    }

    public Page<Products> findAllProdPageable(){
        Sort sort = Sort.by("name");

        Pageable pageable = PageRequest.of(0,2,sort.ascending().and(sort.descending()));
        return prep.findAll(pageable);
    }

}
