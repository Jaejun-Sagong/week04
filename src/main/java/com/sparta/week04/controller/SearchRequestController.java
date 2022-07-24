package com.sparta.week04.controller;

import com.sparta.week04.models.ItemDto;
import com.sparta.week04.utils.NaverShopSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor // final 로 선언된 클래스를 자동으로 생성합니다. //final선언하고 Required어노테이션이 가능한 이유는 컴포넌트 등록을 해줬기 때문이다.
@RestController // JSON으로 응답함을 선언합니다.
public class SearchRequestController {

    private final NaverShopSearch naverShopSearch;

    @GetMapping("/api/search")  //   /api/search?query=검색어 에서 ?앞까지가 주소이다.
    public List<ItemDto> getItems(@RequestParam String query) { //해당 어노테이션은 ?뒤에 적혀있는 것을 파라미터라고 하는데 ?뒤에 적혀있는 것들중에 query라는 애가 있으면 그 녀석을 매개변수로 넣어줘라. 라는 뜻
        String resultString = naverShopSearch.search(query);
        return naverShopSearch.fromJSONtoItems(resultString);
    }
}