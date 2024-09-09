package com.my.shop.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostDetailDto {
    private Long id;

    private String username;
    private String title;
    private String content;
    private int price;

}
