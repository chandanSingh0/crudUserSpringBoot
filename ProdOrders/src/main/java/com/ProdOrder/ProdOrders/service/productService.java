package com.ProdOrder.ProdOrders.service;

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
public class productService {

//    Logger log = Logger.getLogger(productService.class);

    private final productDao prDao;
    public void saveOrUpdate(Product prod){
        log.info("Inserting Product object");
        prDao.save(prod);
    }

    public List<Product> getAllProduct(){
        log.info("Finding all Products");
        return prDao.findAll();
    }

    public Product getProduct(Integer id){
        log.info("Finding product with specific id-{}",id);
        return prDao.findById(id).orElse(null);

//        Optional<Product> pr = prDao.findById(id);
//        if(pr.isPresent()){
//            Product p =pr.get();
//            return p;
//        }
//        throw new RuntimeException("Product not present with"+id);
    }

    public void deleteProd(int prodId){
        log.info("Deleting product object by product id");
        prDao.deleteById(prodId);
    }
}
