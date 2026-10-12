package reflection.field;

import java.lang.reflect.Field;

public class FieldUtil {

    // 어떤 객체든 받아서 기본 값을 적용하는 유틸리티 클래스이다.
    public static void nullFieldToDefault(Object target) throws IllegalAccessException {
        Class<?> aClass = target.getClass();

        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            if(field.get(target) != null) {
                continue;
            }

            if(field.getType() == String.class) {
                field.set(target, "");
            } else if(field.getType() == Integer.class) {
                field.set(target, 0);
            }
        }
    }
}
