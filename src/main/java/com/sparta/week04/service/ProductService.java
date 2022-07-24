package com.sparta.week04.service;

import com.sparta.week04.models.Product;
import com.sparta.week04.models.ProductMypriceRequestDto;
import com.sparta.week04.models.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@Service // 서비스임을 선언합니다.
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional // 메소드 동작이 SQL 쿼리문임을 선언합니다. // 업데이트가 DB관련 작업이고 DB가 바뀌는 걸 트랜잭션이 일어난다고 하고 어노테이션 이름도 트랜잭션이다.
    public Long update(Long id, ProductMypriceRequestDto requestDto) { // 어떤 녀석을 업데이트할지 id를 받고 어떤 값으로 업데이트를 해야할지 Dto를 받는다
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        product.update(requestDto);  // 이 구문을 사용하려면 product에 update 메소드가 있어야한다.
        return id;
    }
}
