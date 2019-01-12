package ch04.item20.domain;

public class VendingMachine extends AbstractVending {
    @Override
    public void chooseProduct() {
        System.out.println("음료수를 선택 한다.");
    }
}
