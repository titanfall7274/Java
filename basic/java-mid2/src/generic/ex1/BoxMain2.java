package generic.ex1;

public class BoxMain2 {

    // 다형적 참조를 통한 해결
    public static void main(String[] args) {
        ObjectBox integerBox = new ObjectBox();
        integerBox.set(1);
//        Object integer = integerBox.get();
        Integer integer = (Integer) integerBox.get(); // Obejct > Integer 캐스팅
        System.out.println("integer = " + integer);

        ObjectBox stringBox = new ObjectBox();
        stringBox.set("hello");
        String string = (String) stringBox.get(); // Obejct > String 캐스팅
        System.out.println("string = " + string);

        // 이 경우 재사용성은 매우 높아졌으나 타입 캐스팅을 해야하며
        // 타입 안정성이 매우매우 떨어진다.
        integerBox.set("문자100"); // 컴파일 에러가 나지 않게되고
        Integer result = (Integer) integerBox.get(); // String > Integer 캐스팅 예외
        // ClassCastException이 발생합니다.
        System.out.println("result = " + result);
    }
}
