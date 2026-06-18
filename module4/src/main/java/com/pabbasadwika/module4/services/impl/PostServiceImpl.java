package com.pabbasadwika.module4.services.impl;

import com.pabbasadwika.module4.dto.PostDto;
import com.pabbasadwika.module4.entities.PostEntity;
import com.pabbasadwika.module4.exception.PostNotFound;
import com.pabbasadwika.module4.repositories.PostRepository;
import com.pabbasadwika.module4.services.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PostDto> getAllPosts() {
       return postRepository.findAll()
                .stream()
                .map(post -> modelMapper.map(post,PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto createPost(PostDto inputPost) {
        PostEntity postEntity = postRepository.save(modelMapper.map(inputPost, PostEntity.class));
        return modelMapper.map(postEntity,PostDto.class);

    }

    @Override
    public PostDto findPost(Long postId) {
        PostEntity postEntity = postRepository.findById(postId).orElseThrow(() -> new PostNotFound(postId));
        return modelMapper.map(postEntity,PostDto.class);
    }

//    @Override
//    public PostDto updatePost(Long postId, PostDto postDto) {
//        PostEntity olderPost = postRepository.findById(postId).orElseThrow(() -> new PostNotFound(postId));
//        postDto.setPostId(postId);
//        modelMapper.map(postDto,olderPost);
//        PostEntity savedPostEntity = postRepository.save(olderPost);
//        return modelMapper.map(savedPostEntity,PostDto.class);
//
//    }


}
