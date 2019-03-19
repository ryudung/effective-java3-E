package ch08.item49;

import org.junit.Test;

import java.util.Objects;


public class Item49Test {

    @Test(expected = AssertionError.class)
    public void test1() {
        Dog dog = new Dog(null);
        dog.getName();

        System.out.println(dog.getName());
    }

    @Test(expected = NullPointerException.class)
    public void test2() {

        Objects.requireNonNull(null, "null 일수 없다.");

    }
}
