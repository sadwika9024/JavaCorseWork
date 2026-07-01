package com.pabbasadwika.module5.springSecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private Long Id;
    private String title;
    private String description;
}
