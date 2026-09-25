package generic.ex4;

// 클래스에 <T>를 할 경우에는 클래스 전체에 적용됩니다.
public class GenericMethod {

    public static Object objectMethod(Object obj) {
        System.out.println("Object print: " + obj);
        return obj;
    }

    // 메서드에만 제네릭이 적용됩니다.
    // <T>: 이 메서드는 제네릭 메서드입니다.
    // T: 타입 매개변수입니다.
    public static <T> T genericMethod(T t) {
        System.out.println("Object print: " + t);
        return t;
    }

    // 제네릭 메서드에도 타입 매개변수 상한 적용이 가능합니다.
    public static <T extends Number> T numberMethod(T t) {
        System.out.println("Number print: " + t);
        return t;
    }


    static <V> V staticMethod2(V t) { return null; } // static 메서드에 제네릭 메서드 도입
    // 단, 제네릭 타입은 static 메서드에 타입 매개변수를 사용하지는 못한다.
    // 객체를 생성하는 시점에 타입이 정해지기 때문이다.
    // ex) static T staticMethod(T t) {}
    <Z> Z instanceMethod2(Z z) { return null; } // 인스턴스 메서드에 제네릭 메서드 도입 가능
}
