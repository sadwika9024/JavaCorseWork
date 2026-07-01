package com.pabbasadwika.module5.springSecurity.service;

import com.pabbasadwika.module5.springSecurity.dto.PostDTO;

import java.util.List;

public interface PostService {

    List<PostDTO> getAllPosts();

    PostDTO createNewPost(PostDTO postDTO);

    PostDTO findPost(Long postId);


    PostDTO updatePost(Long id, PostDTO postDto);
}
