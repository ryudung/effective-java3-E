package ch07.item46;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Person {
	private String name;

	public static Person of(String name){
		return new Person(name);
	}
}
