package com.pabbasadwika.module3.repositories;

import com.pabbasadwika.module3.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    List<ProductEntity> findByTitle(String title);

    List<ProductEntity> findByCreatedAtAfter(LocalDateTime dateTime);

    List<ProductEntity> findByQuantityAndPriceLessThan(int quantity, BigDecimal price);
    List<ProductEntity> findByQuantityGreaterThanAndPriceGreaterThan(int quantity, BigDecimal price);

    List<ProductEntity> findTop2By();

//    Optional<ProductEntity> findByTitleAndPrice(String chocolate, BigDecimal price);

//    @Query("select e from ProductEntity e where e.title=?1 and e.price=?2")
//    Optional<ProductEntity> findByTitleAndPrice(String chocolate, BigDecimal price);

    //query names which we are using should be of java level ex:product entity
    @Query("select e from ProductEntity e where e.title=?1 and e.price=:price")
    Optional<ProductEntity> findByTitleAndPrice(String chocolate, BigDecimal price);

}
