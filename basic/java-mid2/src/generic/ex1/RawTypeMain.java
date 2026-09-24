package generic.ex1;

public class RawTypeMain {

    public static void main(String[] args) {
        // raw type / 원시 타입 >> Object를 사용된다고 이해하면 된다.
        GenericBox integerBox = new GenericBox();
//        GenericBox<Object> integerBox = new GenericBox<>(); // 권장
        integerBox.set(10); // Object value
        Object result = integerBox.get();
        result = (Integer) result;

        System.out.println("result = " + result);
    }
}
