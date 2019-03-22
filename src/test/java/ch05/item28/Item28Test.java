package ch05.item28;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Item28Test {

    @Test(expected = ArrayStoreException.class)
    public void 배열_에러_런타임() {
        Object[] objects = new Long[1];
        objects[0] = "런타임시 에러";
    }

//    @Test
//    public void 리스트는_컴파일에서_에러() {
//        List<Object> list = new ArrayList<Long>(); //컴파일 에러
//
//        list.add("컴파일 에러");
//    }
}
