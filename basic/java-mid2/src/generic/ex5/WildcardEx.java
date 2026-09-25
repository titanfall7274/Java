package generic.ex5;

import generic.animal.Animal;

public class WildcardEx {

    // 비제한 와일드 카드
    static <T> void printGenericV1(Box<T> box) {
        System.out.println("T = " + box.get());
    }

    // 제네릭 메서드가 아닌 일반적인 메서드이다.
    // Box<Dog> dogBox를 전달한다. 와일드카드는 모든 타입을 받을 수 있다.
    // 다음과 같이 해석할 수 있다. ? == Obejct
    static void printWildcardV1(Box<?> box) {
        System.out.println("? = " + box.get());
    }

    static <T extends Animal> void printGenericV2(Box<T> box) {
        System.out.println("T = " + box.get());
        T t = box.get();
        System.out.println("name: " + t.getName());
        System.out.println("size: " + t.getSize());
    }

    // 상한 와일드카드
    static void printWildcardV2(Box<? extends Animal> box) {
        System.out.println("? = " + box.get());
        Animal animal = box.get();
        System.out.println("name: " + animal.getName());
        System.out.println("size: " + animal.getSize());
    }

    // 제네릭 메서드는 반환 타입을 지정할수있다.
    // 때문에 메서드의 타입들을 특정 시점에 변경하려면 제네릭타입, 제네릭 메서드를 활용해야한다.
    static <T extends Animal> T printAndReturnGeneric(Box<T> box) {
        T t = box.get();
        System.out.println("이름: " + t.getName());
        return t;
    }

    // 반면 와일드카드는 이미 만들어진 제네릭 타입을 전달받아서 활용할 때 사용한다.
    // 메서드의 타입을 타입 인자를 통해 변경할 수 없다.
    static Animal printAndReturnWildcard(Box<? extends Animal> box) {
        Animal animal = box.get();
        System.out.println("이름: " + animal.getName());
        return animal;
    }

    // 결과적으로는 제네릭 타입이나 제네릭 메서드가 꼭 필요하다면 <T>를 사용하고,
    // 그렇지 않은 경우에는 와일드 카드를 사용하는 것을 권장한다.
}
