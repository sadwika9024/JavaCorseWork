package com.pabbasadwika.module4.exception;

public class PostNotFound extends RuntimeException {

    public PostNotFound(Long id) {
        super("Post not found with id : " + id);
    }
}
