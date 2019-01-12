package ch04.item20.domain;

import lombok.extern.slf4j.Slf4j;

public abstract class AbstractVending implements VendingService{

    @Override
    public void start() {
        System.out.println("음료수 선택 시작");
    }

    @Override
    public void stop() {
        System.out.println("음료수 선택 끝");
    }

    @Override
    public void process() {
        start();
        chooseProduct();
        start();
    }
}
