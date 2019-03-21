package ch09.item60;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Item60Test {

    @Test
    public void 부정확한_double() {
        //given
        double doubleMoney = 1.03;

        //when
        double result2 = doubleMoney - 0.42;


        //then
        //실패
        assertThat(result2, is(0.61));//0.6100000000000001 나온다!
    }
}
