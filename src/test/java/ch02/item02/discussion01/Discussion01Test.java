package ch02.item02.discussion01;

import ch02.item02.domains.discussion01.Item;
import ch02.item02.domains.discussion01.Discussion01Item;
import ch02.item02.domains.discussion01.ManyRequiredItem;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;


/**
 *
 * 1. 객체에 대한 필수, 옵션 파람을 구분할 수있는 명시적인 방법은 어떤게 있을까?
 * <p>
 *     lombok의 @Nonnull 어노테이션이 쓸만하다.
 *
 * (required parameter, optional parameter 구분을 어떻게 하는게 좋을까?)
 */
public class Discussion01Test {


    /**
     * nonNull Error 확인:
     * - Runtime에서 가능
     * - @Nonnull anotation으로 가능.
     * <p>
     * 장점:
     * - 빌더 패턴의 모든 이점을 그대로 갖는다.
     * <p>
     * 단점:
     * - 개발자가 required 필드, optional 필드를 구분하기 쉽진 않다.
     * (required 필드인지 확인은 Runtime, @Nonnull을 찾아가서 확인해야 한다)
     */
    @Test
    public void 일반적인_lomobk_디폴트세팅() {

        //given
        Item item = Item.builder()
                .id(0L)
                .name("item1")
                .build();

        //then
        Assert.assertThat(item.getId(), is(0L));
        Assert.assertThat(item.getName(), is("item1"));
    }


    /**
     * nonNull Error 확인:
     * - Runtime에서 가능.
     * - 빌더 생성자로 확인가능.
     * - @Nonnull anotation으로 가능.
     * <p>
     * 장점:
     * - 개발자가 required 필드, optional 필드를 구분하기 쉽다.
     * - compile시점에 에러를 확인할 수 있다.
     * <p>
     * 단점:
     * 생성자 방식이 가지는 단점을 그대로 가짐
     * - 빌드 생성자에서는 unreadable 함(생성자에 파라미터가 많을경우 포함)
     * - 같은 타입을 넘길때 발생하는 실수 가능 (intellij에서 생성자에 표시해주긴함 갓텔리))
     */
    @Test
    public void required_필드를_빌더생성자에_받음() {
        //given
        Discussion01Item item
                = Discussion01Item.builder(0L)
                .name("ryudung")
                .build();

        //then
        Assert.assertThat(item.getId(), is(0L));
        Assert.assertThat(item.getName(), is("ryudung"));

    }


    @Test
    public void required_필드가_매우_많아짐() {
        //given
        ManyRequiredItem item = ManyRequiredItem.builder(
                1L,
                "kingbbode",
                "ryudung",
                "hoony",
                "dotori",
                "hongu",
                "jeasang",
                "juNim"
        ).build();


        //then
        Assert.assertThat(item.getId(), is(1L));
        Assert.assertThat(item.getName1(), is("kingbbode"));
        Assert.assertThat(item.getName2(), is("ryudung"));
        Assert.assertThat(item.getName3(), is("hoony"));
        Assert.assertThat(item.getName4(), is("dotori"));
        Assert.assertThat(item.getName5(), is("hongu"));
        Assert.assertThat(item.getName6(), is("jeasang"));
        Assert.assertThat(item.getName7(), is("juNim"));
    }
}
