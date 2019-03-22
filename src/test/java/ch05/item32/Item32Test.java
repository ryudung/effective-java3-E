package ch05.item32;

import org.junit.Test;

public class Item32Test {

    @Test
    public void test1() {
        String[] strArray = toArray("하나", "둘", "셋");
        System.out.println(strArray[0]);
    }

    @Test(expected = ClassCastException.class)
    public void test2() {
        String[] strArray = twoPick("하나", "둘", "셋");
        System.out.println(strArray[0]);
    }

    private <T> T[] twoPick(T a, T b, T c){
        System.out.println("twoPick: " + a.getClass().getName());
        return toArray(a, b);
    }

    //T의 타입은 컴파일타임에 결정된다.
    private <T> T[] toArray(T... args) {
        System.out.println("toArray: "+ args.getClass().getName());
        return args;
    }
}
