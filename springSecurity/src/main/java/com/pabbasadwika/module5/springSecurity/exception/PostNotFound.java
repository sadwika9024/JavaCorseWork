package com.pabbasadwika.module5.springSecurity.exception;

public class PostNotFound extends RuntimeException {

    public PostNotFound(Long id) {
        super("Post not found with id : " + id);
    }
}