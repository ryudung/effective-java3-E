package ch02.item02.discussion02;

import ch02.item02.domains.discussion02.Discussion02BuildItem;
import ch02.item02.domains.discussion02.Discussion02BuildPerMethodItem;
import ch02.item02.domains.discussion02.Discussion02ConstructorItem;
import org.junit.Test;


/**
 * 실무에서 Lombok @builder, @nonNull을 사용하면, 가독성(코딩량 감소, 실수를 줄임)에 좋다.
 * <p>
 * 2. 롬복과 함께 사용할 경우, 불변식은 어디에 어디까지 활용 할수 있을까?)
 * <p>
 * (불변식(파라미터 검증) 로직은 어디에 있는것이 좋을까?)
 * <p>
 * 생성자 vs 빌드메소드 vs 각각 빌드메소드 vs JSR303???
 */
public class Discussion02Test {

    /**
     * 장점: @Builder를 사용할 수 있어서 가독성이 높다.
     * <p>
     * 단점: @Nonnull을 사용할 수 없다.(@Nonnull은 컴파일을 통해 생성자를 사용하여, null체크 로직을 만들어낸다)
     */
    @Test(expected = IllegalArgumentException.class)
    public void 검증_생성자를_사용할_경우() {
        //given
        Discussion02ConstructorItem item = Discussion02ConstructorItem.builder()
                .id(-1L)
                .name("ryudung")
                .build();

    }


    /**
     * 장점: @Nonull을 사용할 수 있다.
     * <p>
     * 단점: @Builder를 사용할 때보다 가독성이 떨어진다(코드양이 많다).
     * <p>
     * 빌더 패턴을 통해 객체를 생성할 때, 보통 private한 모든생성자 매서드를 만들어 사용하게 된다.
     * 이 경우,
     * lombok에 '@AllArgsConstructor(access = AccessLevel.PRIVATE)'가 코드를 줄여줄수 있다.
     */
    @Test(expected = IllegalArgumentException.class)
    public void 검증_빌드메소드를_사용할_경우() {
        //given
        Discussion02BuildItem item = Discussion02BuildItem.builder()
                .id(-1L)
                .name("ryudung")
                .build();

    }

    /**
     * 장점:
     * - @Nonull을 사용할 수 있다.
     * - 메소드 각각에 복잡한 검증 로직을 분리할 수 있다.
     * - build() 메서드 보다 빠른 checking.
     * <p>
     * 단점: @Builder를 사용할 때보다 가독성이 떨어진다(코드양이 많다)
     * <p>
     * 빌더 패턴을 통해 객체를 생성할 때, 보통 private한 모든생성자 매서드를 만들어 사용하게 된다.
     * 이 경우,
     * lombok에 '@AllArgsConstructor(access = AccessLevel.PRIVATE)'가 코드를 줄여줄수 있다.
     */
    @Test(expected = IllegalArgumentException.class)
    public void 검증_각_빌드메소드를_사용할_경우() {
        //given
        Discussion02BuildPerMethodItem item = Discussion02BuildPerMethodItem.builder()
                .id(-1L)
                .name("ryudung")
                .build();

    }
}
