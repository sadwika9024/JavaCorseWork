package com.pabbasadwika.module4.controller;

import com.pabbasadwika.module4.dto.PostDto;
import com.pabbasadwika.module4.services.impl.PostServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {


    private final PostServiceImpl postService;

    @GetMapping("/allPost")
    public ResponseEntity<List<PostDto>> allPost(){
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @PostMapping("/postMessage")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        return ResponseEntity.ok(postService.createPost(postDto));
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> findPost(@PathVariable(name = "postId") Long id){
        return ResponseEntity.ok(postService.findPost(id));
    }

//    @PutMapping("/postMessage/{postId}")
//    public ResponseEntity<PostDto> updatePost(@PathVariable(name = "postId") Long id,@RequestBody PostDto postDto){
//        return ResponseEntity.ok(postService.updatePost(id,postDto));
//    }
}
