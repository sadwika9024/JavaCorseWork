package com.pabbasadwika.module4.services;

import com.pabbasadwika.module4.dto.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {

    List<PostDto> getAllPosts();
    PostDto createPost(PostDto inputPost);
    PostDto findPost(Long postId);


//    PostDto updatePost(Long id, PostDto postDto);
}
