package generic.ex1;

public class BoxMain3 {

    // 제네릭을 적용하여
    // 타입 안정성
    // 코드 재사용
    // 이라는 두마리 토끼를 모두 붙잡을 수 있었다.
    public static void main(String[] args) {
        GenericBox<Integer> integerBox = new GenericBox<Integer>();
        integerBox.set(1);
        Integer integer = integerBox.get();
        System.out.println("value = " + integer);

        GenericBox<String> stringBox = new GenericBox<String>();
        stringBox.set("hello");
        String str = stringBox.get();
        System.out.println("value = " + str);

        GenericBox<Double> doubleBox = new GenericBox<Double>();
        doubleBox.set(1.2);
        Double doubleValue = doubleBox.get();
        System.out.println("value = " + doubleValue);

        // 타입 추론: 자바가 스스로 타입 정보를 추론해서 개발자가 타입 정보를 생략할 수 있는 것
        // 이렇게 추론이 가능한 상황에 생략이 가능합니다.
        GenericBox<Integer> integerBox2 = new GenericBox<>();
    }
}
