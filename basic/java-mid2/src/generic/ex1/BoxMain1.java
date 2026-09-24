package generic.ex1;

public class BoxMain1 {

    // 가장 원시적으로 IntegerBox와 StringBox를 만든 뒤
    // 각각의 상자에 맞는 자료형의 타입을 setter를 통해 초기화 하고
    // 값을 꺼내 사용한다.
    public static void main(String[] args) {
        IntegerBox integerBox = new IntegerBox();
        integerBox.setValue(10);
//        integerBox.setValue("20"); // compile Error가 발생하여 타입 안정성이 높다.
        Integer integer = integerBox.getValue();
        System.out.println("integer = " + integer);

        StringBox stringBox = new StringBox();
        stringBox.setValue("Hello");
        String string = stringBox.getValue();
        System.out.println("string = " + string);

        // 그러나 이런 경우 타입별로 xxxBox라는 형식으로 새로운 클래스를 계속 만들어야 한다는 단점이 존재한다.
    }
}
