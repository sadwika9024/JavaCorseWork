package com.pabbasadwika.module5.springSecurity.respository;

import com.pabbasadwika.module5.springSecurity.entities.Postentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Postentity,Long> {
}
