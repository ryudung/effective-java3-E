package ch06.item34;

/**
 * 열거타입 별로 구현 내용이 다를 경우
 * if, switch 보다 열거타입으로 나누어 유연하게 사용하자.
 */
public enum Dog {
	SCHNAUZER {
		@Override
		public void bark() {
			System.out.println("멍멍멍멍멍");
		}
	},
	HUSKY {
		@Override
		public void bark() {
			System.out.println("왈왈");
		}
	},
	POODLE {
		@Override
		public void bark() {
			System.out.println("멍멍");
		}
	};

	/**
	 * 활동대사량
	 */
	abstract public void bark();
}
