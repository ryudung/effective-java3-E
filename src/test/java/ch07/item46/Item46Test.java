package ch07.item46;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Item46Test {
	@Test
	public void test1() {

		List<Person> people = Arrays.asList(
				Person.of("ryudung"),
				Person.of("ryudung"),
				Person.of("jo"),
				Person.of("dotori"),
				Person.of("kking")
		);


		List<String> list = people.stream()
				.map(Person::getName)
				.collect(Collectors.toList());

		list.forEach(System.out::println);

		System.out.println("==========");


		Set<String> set = people.stream()
				.map(Person::getName)
				.collect(Collectors.toCollection(TreeSet::new));

		set.forEach(System.out::println);
	}

	@Test
	public void test2() {
		List<String> things = Arrays.asList("ryudung", "jo", "dotori", "kking");


		String joined = things.stream()
				.map(Object::toString)
				.collect(Collectors.joining(", "));

		System.out.println(joined);
	}

	@Test
	public void test3() {
		List<Employee> employees = Arrays.asList(
				Employee.of("ryudung", 40, Department.of("potalDevelop")),
				Employee.of("jo", 55, Department.of("potalDevelop")),
				Employee.of("dotori", 41, Department.of("devOps")),
				Employee.of("kking", 42, Department.of("publising")),
				Employee.of("beyond", 43, Department.of("design"))
		);


		int total = employees.stream()
				.collect(Collectors.summingInt(Employee::getSalary));

		System.out.println("total: " + total);

		System.out.println("==========");


		Map<String, List<Employee>> byDept = employees.stream()
				.collect(Collectors.groupingBy(o -> o.getDepartment().getName()));

		byDept.keySet()
				.forEach(key -> {
					String names = byDept.get(key).stream()
							.map(Employee::getName)
							.collect(Collectors.joining(", "));

					System.out.println(key + " : " + names);
				});

		System.out.println("==========");


		Map<String, Integer> totalByDept = employees.stream()
				.collect(Collectors.groupingBy(employee -> employee.getDepartment().getName(),
						Collectors.summingInt(Employee::getSalary)));

		totalByDept.keySet()
				.forEach(key -> System.out.println(key + " : " + totalByDept.get(key)));
	}

	@Test
	public void test4() {
		int PASS_THRESHOLD = 50;

		List<Student> students = Arrays.asList(
				Student.of("ryudung", 45),
				Student.of("jo", 46),
				Student.of("dotori", 95),
				Student.of("kking", 85)
		);


		Map<Boolean, List<Student>> passingFailing = students.stream()
				.collect(Collectors.partitioningBy(s -> s.getGrade() >= PASS_THRESHOLD));

		passingFailing.keySet()
				.forEach(key -> {
					String names = passingFailing.get(key).stream()
							.map(Student::getName)
							.collect(Collectors.joining(", "));

					System.out.println("test pass : " + key);
					System.out.println("names : " + names);
					System.out.println("====================");
				});
	}
}
