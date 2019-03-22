package ch05.item33;


import org.codehaus.jackson.type.TypeReference;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Item33Test {
    @Test
    public void 이종_타입_컨테이너() {
        Favorites f = new Favorites();

        f.putFavorite(String.class, "스트링");
        f.putFavorite(Integer.class, 1);
        f.putFavorite(Long.class, 1L);

        assertEquals("스트링", f.getFavorite(String.class));
        assertEquals(new Integer(1), f.getFavorite(Integer.class));
        assertEquals(new Long(1L), f.getFavorite(Long.class));

    }

    @Test
    public void 이종_타입_컨테이너_실체화_불가_타입_문제() {
        Favorites f = new Favorites();

        f.putFavorite(String[].class, new String[1]);

        //컴파일 에러 발생! 지원하지 않는 타입
//        f.putFavorite(List<String>.class, new ArrayList<>());

    }

    @Test
    public void 이종_타입_컨테이너_실체화_불가_타입_슈퍼타입_토큰() {
        //given
        Favorites f = new Favorites();

        // 슈퍼타입으로 넣는다!
        f.putFavorite(new TypeReference<List<String>>() {}, Collections.singletonList("슈퍼 타입 토큰"));

        // 슈퍼타입으로 꺼낸다!
        List<String> strings = f.getFavorite(new TypeReference<List<String>>() {});

        //then
        assertEquals("슈퍼 타입 토큰", strings.get(0));
    }

}
