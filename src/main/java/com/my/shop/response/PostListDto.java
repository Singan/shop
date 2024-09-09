package com.my.shop.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostListDto {


    //- id : 게시글 번호 (DB 인덱스)
    //- username : 작성자
    //- title (String) :  게시글 제목
    //- price(int) : 가격

    private Long id;
    private String title;
    private String username;
    private int price;

}
