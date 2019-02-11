package ch06.item34;

/**
 * 열거타입 내부에서 정해진 기준으로 메서드를 사용하게 된 경우,
 * 내부에 다시 열거타입으로 나누어, 유연함을 유지하자.
 * <p>
 * 적절한 예시가 생각나지 않는다...
 */
public enum Dog2 {
	SCHNAUZER(Snack.NONE),
	HUSKY(Snack.EGG),
	POODLE(Snack.SAUSAGE);


	private final Snack favoriteSnack;

	Dog2(Snack favoriteSnack) {
		this.favoriteSnack = favoriteSnack;
	}

	public String getSnackInfo() {
		return favoriteSnack.getInfo();
	}

	/**
	 * 간식
	 */
	enum Snack {
		SAUSAGE(50) {
			@Override
			String getInfo() {
				return "from china";
			}
		},
		EGG(20) {
			@Override
			String getInfo() {
				return "from korea";
			}
		},
		NONE(0) {
			@Override
			String getInfo() {
				return "from japan";
			}
		};

		private final int calorie;

		Snack(int calorie) {
			this.calorie = calorie;
		}

		abstract String getInfo();
	}
}
