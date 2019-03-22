package ch05.item33;

import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.TypeReference;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Favorites {

    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance) {
        //cast 메서드를 사용해 타입 안정성을 보장한다!
        favorites.put(Objects.requireNonNull(type), type.cast(instance));
    }

    public <T> T getFavorite(Class<T> type) {
        //cast 메서드를 사용해 타입 안정성을 보장한다!
        return type.cast(favorites.get(type));
    }

    //슈퍼타입을 사용하여 타입안정성을 보장한다!
    public <T> void putFavorite(TypeReference<T> valueTypeRef, T instance) {

        // ParameterizedType로 캐스팅하여 Class<T>를 얻는다!
        Class<T> tClass = ((Class<T>) ((ParameterizedType) valueTypeRef.getType()).getRawType());

        favorites.put(Objects.requireNonNull(tClass), Objects.requireNonNull(instance));
    }

    //슈퍼타입을 사용하여 타입안정성을 보장한다!
    public <T> T getFavorite(TypeReference<T> valueTypeRef) {

        // TypeFactory를 이용해서 Class<T>를 얻는다!
        Class<T> rawClass = (Class<T>) TypeFactory.type(valueTypeRef.getType()).getRawClass();

        return rawClass.cast(favorites.get(rawClass));
    }
}
