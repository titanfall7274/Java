package lamda.lambda3;

public class GenericMain2 {

    public static void main(String[] args) {
        // Object 클래스에는 upperCase()라는 함수가 없다.
        // String class의 기능이기 때문에 캐스팅이 필요하다.
        ObjectFunction upperCase = str -> ((String)str).toUpperCase();
        String result1 = (String) upperCase.apply("hello");
        System.out.println("result1 = " + result1);

        ObjectFunction square = n -> (Integer) n * (Integer) n;
        Object result2 = square.apply(3);
        System.out.println("result2 = " + result2);

        // Object는 모든 타입의 부모이기에 파라미터로 Obejct를 사용하면 다형성(다형적 참조)를 이룰수는 있다.
        // 단, Object를 사용하기 때문에 복잡하고도 안전하지 않은 타입 캐스팅 과정이 필요하다.
    }

    @FunctionalInterface
    interface ObjectFunction{
        Object apply(Object o);
    }
}
