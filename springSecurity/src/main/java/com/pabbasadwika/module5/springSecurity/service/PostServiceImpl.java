package com.pabbasadwika.module5.springSecurity.service;

import com.pabbasadwika.module5.springSecurity.dto.PostDTO;
import com.pabbasadwika.module5.springSecurity.entities.Postentity;
import com.pabbasadwika.module5.springSecurity.exception.PostNotFound;
import com.pabbasadwika.module5.springSecurity.respository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{


    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<PostDTO> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(post -> modelMapper.map(post,PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO createNewPost(PostDTO postDTO) {
        Postentity postEntity = postRepository.save(modelMapper.map(postDTO, Postentity.class));
        System.out.println(postEntity.toString());
        return modelMapper.map(postEntity,PostDTO.class);
    }

    @Override
    public PostDTO findPost(Long postId) {
        Postentity postEntity = postRepository.findById(postId).orElseThrow(() -> new PostNotFound(postId));
        return modelMapper.map(postEntity,PostDTO.class);
    }

        @Override
    public PostDTO updatePost(Long postId, PostDTO postDto) {
        Postentity olderPost = postRepository.findById(postId).orElseThrow(() -> new PostNotFound(postId));
        postDto.setId(postId);
        modelMapper.map(postDto,olderPost);
        Postentity savedPostEntity = postRepository.save(olderPost);
        return modelMapper.map(savedPostEntity,PostDTO.class);

    }
}
