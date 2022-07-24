package com.sparta.week04.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


// ID가 자동으로 생성 및 증가합니다.
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Product extends Timestamped {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private int lprice;

    @Column(nullable = false)
    private int myprice;

    // 관심 상품 생성 시 이용합니다.
    public Product(ProductRequestDto requestDto) { //product 생성자로써 controller 메소드에서 쓰인다.
        this.title = requestDto.getTitle();
        this.image = requestDto.getImage();
        this.link = requestDto.getLink();
        this.lprice = requestDto.getLprice();
        this.myprice = 0;  //내가 가격등록 안하고 관심상품으로 등록하면 최저가 딱지가 안붙어나와야 하므로 0원으로 설정해 안붙도록 한다.
    }

    // 관심 가격 변경 시 이용합니다.
    public void update(ProductMypriceRequestDto requestDto) {   //service에서 업데이트 메소드에서 이 product 메소드가 사용된다.
        this.myprice = requestDto.getMyprice();
    }
}