package com.my.shop.entity;

import com.my.shop.request.PostUpdateDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "item")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)


public class ItemEntity {

    //- id : 게시글 번호 (DB 인덱스)
    //- username : 작성자
    //- title (String) :  게시글 제목
    //- content (String) : 게시글 내용
    //- price(int) : 가격
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String title;
    private String content;
    private int price;
    @Builder
    public ItemEntity(String username, String title, String content, int price) {
        this.username = username;
        this.title = title;
        this.content = content;
        this.price = price;
    }


    public void itemUpdate(PostUpdateDto postUpdateDto){
        this.username = postUpdateDto.getUsername();
        this.title = postUpdateDto.getTitle();
        this.content = postUpdateDto.getContent();
        this.price = postUpdateDto.getPrice();
    }
}
