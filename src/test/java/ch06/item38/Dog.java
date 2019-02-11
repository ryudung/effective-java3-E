package ch06.item38;

/**
 * enum(열거타입) 확장해서 사용하기
 */
public enum Dog implements Animal {
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
}
