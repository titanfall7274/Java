package generic.ex3;

import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalHospitalMainV2 {

    public static void main(String[] args) {
        AnimalHostpitalV2<Dog> dogHospital = new AnimalHostpitalV2<>();
        AnimalHostpitalV2<Cat> catHospital = new AnimalHostpitalV2<>();

        // T에 Dog, Cat말고도 다른 타입들이 제네릭 타입으로 가능하게된다.
        AnimalHostpitalV2<Integer> integerHospital = new AnimalHostpitalV2<>();
        AnimalHostpitalV2<Double> doubleHospital = new AnimalHostpitalV2<>();
        AnimalHostpitalV2<Object> objectHospital = new AnimalHostpitalV2<>();

        // 문제
        // 1. 제네릭에서 타입 매개변수를 사용하면 어떤 타입이든 들어올 수 있다.
        // 2. 타입 매개변수를 어떤 타입이든 수용할 수 있는 Object로 가정하고, Object의 기능만 사용할 수 있다.

        // 타입 매개변수를 Animal로 제한하지 않았기 때문에 발생하는 문제들이다.
    }
}
