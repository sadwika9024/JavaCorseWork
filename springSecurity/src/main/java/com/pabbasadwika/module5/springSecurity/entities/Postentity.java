package com.pabbasadwika.module5.springSecurity.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Postentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    private String title;

    private String description;

}
