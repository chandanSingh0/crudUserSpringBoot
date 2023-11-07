package com.example.demo.repository;

import com.example.demo.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface productRepository extends JpaRepository<Products,Long> {
    @Query("SELECT p from Products p where p.description like '%Mob%'")
    List<Products> findAllProductsWithDescriptiion();

    //Internal Server Error because p Unknown column 'p' in 'field list'
//
    @Query(nativeQuery = true,value = "SELECT * from Products p where p.description like '%Mob%' ")
    List<Products> findAllNativeProductsWithDescriptiion();

//    with parametetrs
    @Query("select p from Products p where p.description like :desc")
    List<Products> findAllWithParameters(@Param("desc")String description);

    @Query("select p from Products p where p.description like %?1%")
    List<Products> findAllProd(String description);

    @Query("select p from Products p where p.description IN (:description)")
    List<Products> findAllProdList(@Param("description") List<String> description);

    @Query("select p from Products p order by p.name asc")
    List<Products> findAllByAsc();

    @Query("select count(p) from Products p group by p.description")
    List<String> findProdbydistDescription();

    Page<Products> findAll(Pageable pageable);




}
