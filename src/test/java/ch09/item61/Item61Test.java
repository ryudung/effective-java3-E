package ch09.item61;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Item61Test {

    @Test(expected = NullPointerException.class)
    public void test() {
        //given
        int a = 1;
        Integer b = null;

        //then
        if (b == a) {
            //someThing job
        }

    }

    @Test
    public void test1() {

        //given
        Integer a = new Integer(1);
        Integer b = new Integer(1);

        //then

        //a와 b의 객체 참조 값을 비교한다!!
        assertFalse(a == b);


        assertTrue(a == b.intValue());


        assertTrue(a.intValue() == b.intValue());
    }

    @Test
    public void name() {

        //given
        Integer a = 1;
        Integer b = 1;

        //then
        assertTrue(a == b);

    }
}
