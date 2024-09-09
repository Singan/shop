package com.my.shop.repository;

import com.my.shop.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<ItemEntity , Long> {



}
