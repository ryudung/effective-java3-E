package ch07.item46;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Student {
	private String name;
	private int grade;

	public static Student of(String name, int grade) {
		return new Student(name, grade);
	}
}
