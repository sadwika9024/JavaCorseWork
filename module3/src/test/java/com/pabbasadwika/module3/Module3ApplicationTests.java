package com.pabbasadwika.module3;

import com.pabbasadwika.module3.dto.ProductInfoProjection;
import com.pabbasadwika.module3.dto.QuantityGroupBy;
import com.pabbasadwika.module3.entities.ProductEntity;
import com.pabbasadwika.module3.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class Module3ApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}
//
//	@Test
//	void testRepository(){
//		ProductEntity productEntity = ProductEntity.builder()
//				.sku("nestle1234")
//				.title("chocolate12")
//				.price(BigDecimal.valueOf(10.00))
//				.quantity(100)
//				.build();
//
//
//		productRepository.save(productEntity);
//		System.out.println(productEntity);
//	}

	@Test
	void testAllData(){
		List<ProductEntity> allData = productRepository.findAll();
		System.out.println(allData);
	}

	@Test
	void sortbyTitle(){
		List<ProductEntity> byTitleName = productRepository.findByTitle("Headphones");
		System.out.println(byTitleName);
	}

	@Test
	void getRepository(){
		//List<ProductEntity> entity =  productRepository.findByCreatedAtAfter(LocalDateTime.of(2026,6,11,0,0,0));
		//List<ProductEntity> entity = productRepository.findByQuantityAndPriceLessThan(100, BigDecimal.valueOf(10));
		//List<ProductEntity> entity = productRepository.findTop2By();
		List<ProductEntity> entity = productRepository.findByQuantityGreaterThanAndPriceGreaterThan(100, BigDecimal.valueOf(10));

		System.out.println(entity);
	}

	@Test
	void getSingleProduct(){
		Optional<ProductEntity> productEntity = productRepository.findByTitleAndPrice("chocolate", BigDecimal.valueOf(10));
		productEntity.ifPresent(System.out::println);
	}

	@Test
	void getProjectedData(){
		//List<ProductInfoProjection> all = productRepository.getAllProductInfoProjection();
//		List<ProductInfoProjection> all = productRepository.getAllProductInfoProjectionClass();
//		List<QuantityGroupBy> qn = productRepository.getAllQuantityGroupByClass();

//		for(ProductInfoProjection p : all){
//			System.out.println(p.getId() + p.getTitle());
//		}

//		for(QuantityGroupBy q : qn){
//			System.out.println(q);
//		}
		System.out.println(productRepository.updatePatientwithId("laptop", 5L));
	}



}
