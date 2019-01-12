package ch04.item20;

import ch04.item20.domain.VendingMachine;
import org.junit.Test;

public class SkeletalImplementationTest {

    @Test
    public void 스켈레톤_구현을_사용해보자() {
        //given
        VendingMachine machine= new VendingMachine();

        //then
        machine.process();
    }
}
