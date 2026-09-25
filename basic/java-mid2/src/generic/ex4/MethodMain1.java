package generic.ex4;

public class MethodMain1 {

    public static void main(String[] args) {
        Integer i = 10;

        Object obj = GenericMethod.objectMethod(i);
        Integer result = (Integer) GenericMethod.objectMethod(i);
        System.out.println("obj = " + obj);

        // 타입 인자(Type argument) 명시적 전달
        System.out.println("명시적 타입 인자 전달");
        Integer integer = GenericMethod.<Integer>genericMethod(i);
        Integer integer2 = GenericMethod.genericMethod(i); // i에 int라는 타입이 들어가므로 타입 생략이 가능하다.
        System.out.println("integer = " + integer);

        Integer integerValue = GenericMethod.<Integer>numberMethod(20);
        Integer integerValue2 = GenericMethod.numberMethod(20);
        System.out.println("integerValue = " + integerValue);

        Double doubleValue = GenericMethod.<Double>numberMethod(12.34);
        Double doubleValue2 = GenericMethod.numberMethod(12.34);
        System.out.println("doubleValue = " + doubleValue);

        String hello = GenericMethod.<String>genericMethod("hello");
        String hello2 = GenericMethod.genericMethod("hello");
//        String hello1 = GenericMethod.<String>numberMethod("Hello"); // Number의 자식이 아니라는 컴파일 에러를 내준다.
    }
}
