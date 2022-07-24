package com.sparta.week04.models;

import lombok.Getter;
import org.json.JSONObject;

@Getter
public class ItemDto {   //내가 DB에서 가져온 정보를 클라이언트에 돌려주기 위해 만든 Dto //Setter가 없는 이유는 하나씩 가져갈 일이 없고 생성자로 데이터를 사용하므로
    private String title;
    private String link;
    private String image;
    private int lprice;

    public ItemDto(JSONObject itemJson) {
        this.title = itemJson.getString("title");
        this.link = itemJson.getString("link");
        this.image = itemJson.getString("image");
        this.lprice = itemJson.getInt("lprice");
    }
}
