package ch07.item44;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class Item44Test {

	@Test
	public void unaryOperator() {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		UnaryOperator<Integer> unaryOperatorInteger = (i) -> i * i;

		UnaryOperator<String> unaryOperatorString = (i) -> i + i;

		list.forEach(i -> System.out.println(unaryOperatorInteger.apply(i)));

		list.forEach(i -> System.out.println(unaryOperatorString.apply(String.valueOf(i))));

	}

	@Test
	public void binaryOperator() {

		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 2);
		map.put(2, 3);
		map.put(3, 4);

		BinaryOperator<Integer> unaryOperatorInteger = (i, j) -> i * j;

		BinaryOperator<String> unaryOperatorString = (i, j) -> i + j;

		map.keySet()
				.forEach(key -> System.out.println(
						unaryOperatorInteger
								.andThen(integer -> {
									System.out.println(key + "*" + map.get(key) + "=");
									return integer;
								})
								.apply(key, map.get(key))
				));

		map.keySet()
				.forEach(key -> System.out.println(
						unaryOperatorString
								.andThen(integer -> {
									System.out.println(key + " append " + map.get(key) + "=");
									return integer;
								})
								.apply(String.valueOf(key), String.valueOf(map.get(key)))
				));
	}


	@Test
	public void predicate() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		Predicate<Integer> predicate1 = (i) -> i >= 3;

		Predicate<Integer> predicate2 = (i) -> i <= 3;

		list.forEach(integer -> System.out.println(predicate1
				.and(predicate2)
				.negate()
				.test(integer)));

	}

	@Test
	public void function() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		Function<Integer, String> function1 = (i) -> i + ",000원";
		Function<Integer, Integer> function2 = (i) -> i * 2;

		list.forEach(integer -> System.out.println(
				function1
						.andThen(s -> {
							System.out.println("==1==");
							return s;
						})
						.compose(function2)
						.apply(integer)));

	}

	@Test
	public void supplier() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		Supplier<String> supplier = () -> ",000원";

		Function<Integer, String> function = (i) -> i + supplier.get();

		list.forEach(integer -> System.out.println(function.apply(integer)));
	}

	@Test
	public void consumer() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		Consumer<Integer> consumer1 = System.out::println;

		Consumer<Integer> consumer2 = (i) -> {
			System.out.println(i * 2);
			System.out.println("========");
		};

		list.forEach(
				integer -> consumer1
						.andThen(consumer2)
						.accept(integer)
		);
	}


	@Test
	public void myFunctionInterface() {

		MyFunctionInterface<Integer, Long, Double, Float, String> myFunctionInterface
				= (i, l, d, f) -> String.valueOf(i + l + d + f);

		System.out.println(myFunctionInterface.apply(1, 2L, 3.0, 4.0F));
	}
}
