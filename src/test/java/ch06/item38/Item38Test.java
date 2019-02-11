package ch06.item38;

import org.junit.Test;

public class Item38Test {

	@Test
	public void test() {
		barks1(Dog.class);
		barks2(Dog.values());
	}

	private <T extends Enum<T> & Animal> void barks1(Class<T> dogType) {
		for (Animal animal : dogType.getEnumConstants()) {
			animal.bark();
		}
	}

	private void barks2(Dog[] values) {
		for (Animal animal : values) {
			animal.bark();
		}
	}
}
