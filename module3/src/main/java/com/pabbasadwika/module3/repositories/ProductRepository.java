package com.pabbasadwika.module3.repositories;

import com.pabbasadwika.module3.dto.ProductInfoProjection;
import com.pabbasadwika.module3.dto.QuantityGroupBy;
import com.pabbasadwika.module3.entities.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    List<ProductEntity> findByTitle(String title);
    List<ProductEntity> findByTitleContainingIgnoreCase(String title, Pageable pageable);
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

   // List<ProductEntity> findByOrderByPrice();

     List<ProductEntity> findBy(Sort sort);

     //for projection
    @Query("select e.id as id,e.title as title,e.price as price from ProductEntity e")
        List<ProductInfoProjection> getAllProductInfoProjection();

    @Query("select new com.pabbasadwika.module3.dto.CProductInfoProjection (e.id ,e.title) " +
            "from ProductEntity e")
    List<ProductInfoProjection> getAllProductInfoProjectionClass();

    @Query("select new com.pabbasadwika.module3.dto.QuantityGroupBy (p.quantity,"+
    "COUNT(p)) from ProductEntity p group by p.quantity")
    List<QuantityGroupBy> getAllQuantityGroupByClass();

    @Transactional
    @Modifying
    @Query("UPDATE ProductEntity e set e.title=:name where e.id=:id")
    int updatePatientwithId(@Param("name") String title,@Param("id")Long id);

}
