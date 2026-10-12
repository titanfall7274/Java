package reflection.data;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class BasicV2 {

    public static void main(String[] args) {
        Class<BasicData> basicData = BasicData.class;

        // reflection.data.BasicData
        System.out.println("basicData.getName() = " + basicData.getName());

        // BasicData
        System.out.println("basicData.getSimpleName() = " + basicData.getSimpleName());

        // reflection.data
        System.out.println("basicData.getPackage() = " + basicData.getPackage());

        // java.lang.Object
        System.out.println("basicData.getSuperclass() = " + basicData.getSuperclass());

        // []
        System.out.println("basicData.getInterfaces() = " + Arrays.toString(basicData.getInterfaces()));

        // false
        System.out.println("basicData.isInterface() = " + basicData.isInterface());

        // false
        System.out.println("basicData.isEnum() = " + basicData.isEnum());

        // false
        System.out.println("basicData.isAnnotation() = " + basicData.isAnnotation());

        // 수정자가 조합된숫자 modifiers
        int modifiers = basicData.getModifiers();
        System.out.println("modifiers = " + modifiers); // 1

        // Modifier를 통해 실제 수정자 정보를확인
        System.out.println("Modifier.isPublic(modifiers) = " + Modifier.isPublic(modifiers)); // true
        System.out.println("Modifier.toString(modifiers) = " + Modifier.toString(modifiers)); // public

        // 참고 수정자는 접근 제어자 <> 비 접근 제어자(기타 수정자)
        // 접근 제어자
        // public, protected, default(package-private), private

        // 비 접근 제어자
        // static, final, abstract, synchronized, volatile 등
    }
}
