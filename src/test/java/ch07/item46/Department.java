package ch07.item46;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Department {

	private String name;

	public static Department of(String name) {
		return new Department(name);
	}
}
