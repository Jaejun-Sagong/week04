package com.sparta.week04.models;

import lombok.Getter;

@Getter
public class ProductRequestDto {  // Dto에 들어갈 정보 변수로 선언 // 관심상품으로 등록할 때 쓰기위해 만든 Dto
    private String title;
    private String link;
    private String image;
    private int lprice;
}