package com.pabbasadwika.module3.controller;

import com.pabbasadwika.module3.entities.ProductEntity;
import com.pabbasadwika.module3.repositories.ProductRepository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    private final ProductRepository productRepository;
    private final int PAGE_SIZE = 3;


    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    //http://localhost:8080/getAllProducts?sortBy=quantity
    //http://localhost:8080/getAllProducts?title=smart&sortBy=price&page=0
    @GetMapping("/getAllProducts")
    public List<ProductEntity> sortAllProducts(
                                                @RequestParam(defaultValue = "") String title,
                                                @RequestParam(defaultValue = "id") String sortBy,
                                               @RequestParam(defaultValue = "0") Integer page
                                               ){
        //return productRepository.findByOrderByPrice();
        //return productRepository.findBy(Sort.by(Sort.Direction.DESC,sortBy,"price"));
//        return productRepository.findBy(
//                Sort.by(
//                        Sort.Order.desc(sortBy),
//                        Sort.Order.asc("price")
//                )
//        );
        Pageable pageable = PageRequest.of(page,PAGE_SIZE,Sort.by(Sort.Order.desc(sortBy)));


        return productRepository.findByTitleContainingIgnoreCase(title,
                                                                pageable);

    }
}
