package com.my.shop.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostUpdateDto {

    private String username;
    private String content;
    private String title;
    private int price;
}
