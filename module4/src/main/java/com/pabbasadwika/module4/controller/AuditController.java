package com.pabbasadwika.module4.controller;

import com.pabbasadwika.module4.entities.PostEntity;
import com.pabbasadwika.module4.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/audit")
@RequiredArgsConstructor
public class AuditController {

    private final PostService postService;

    @GetMapping("/{postId}")
    public ResponseEntity<List<PostEntity>> allUpdatesOnPOstId(@PathVariable(name = "postId") Long id){
        return null;
    }


}
