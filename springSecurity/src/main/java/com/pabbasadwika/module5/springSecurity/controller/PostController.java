package com.pabbasadwika.module5.springSecurity.controller;

import com.pabbasadwika.module5.springSecurity.dto.PostDTO;
import com.pabbasadwika.module5.springSecurity.service.PostServiceImpl;
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
    public ResponseEntity<List<PostDTO>> allPost(){
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @PostMapping("/postMessage")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDto){
        return ResponseEntity.ok(postService.createNewPost(postDto));
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDTO> findPost(@PathVariable(name = "postId") Long id){
        return ResponseEntity.ok(postService.findPost(id));
    }

    @PutMapping("/postMessage/{postId}")
    public ResponseEntity<PostDTO> updatePost(@PathVariable(name = "postId") Long id, @RequestBody PostDTO postDto){
        return ResponseEntity.ok(postService.updatePost(id,postDto));
    }



}
