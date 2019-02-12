package ch07.item46;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Employee {
	private String name;
	private int salary;
	private Department department;

	public static Employee of(String name, int salary, Department department){
		return new Employee(name, salary, department);
	}
}
