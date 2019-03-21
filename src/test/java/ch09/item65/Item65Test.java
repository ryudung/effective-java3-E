package ch09.item65;

import org.junit.Test;

import java.util.Map;

public class Item65Test {

    /**
     * 리플렉션은 인스턴스 생성에만 쓰고, 이렇게 만든 인스턴스는 인터페이스나 상위 클래스로 참조해 사용하자.
     */
    @Test
    public void test() {
        Class<?> cl = null;

        try {
            cl = Class.forName("java.util.HashMap");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Map<String, String> map = null;

        try {
            map = (Map<String, String>) cl.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        map.put("이름", "hashMap");

        System.out.println(map.get("이름"));
    }

}
