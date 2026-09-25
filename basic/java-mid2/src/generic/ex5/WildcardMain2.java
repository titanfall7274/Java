package generic.ex5;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class WildcardMain2 {

    public static void main(String[] args) {
        // 하한 와일드 카드(단, 제네릭에는 없는 기능이고 참고만 하면 된다.)
        Box<Object> objectBox = new Box<>();
        Box<Animal> animalBox = new Box<>();
        Box<Dog> dogBox = new Box<>();
        Box<Cat> catBox = new Box<>();

        // Animal 포함 상위 타입 전달 가능
        writeBox(objectBox);
        writeBox(animalBox);
//        writeBox(dogBox);
//        writeBox(catBox);
    }

    static void writeBox(Box<? super Animal> box) {
        box.set(new Dog("멍멍이", 100));
    }
}
