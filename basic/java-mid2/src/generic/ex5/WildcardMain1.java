package generic.ex5;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class WildcardMain1 {

    public static void main(String[] args) {
        Box<Object> objectBox = new Box<>();
        Box<Dog> dogBox = new Box<>();
        Box<Cat> catBox = new Box<>();

        dogBox.set(new Dog("멍멍이", 100));
        WildcardEx.printGenericV1(dogBox);
        WildcardEx.printWildcardV1(dogBox);

        System.out.println("printGenericV2");
        WildcardEx.printGenericV2(dogBox);
        WildcardEx.printWildcardV2(dogBox);

        System.out.println("printAndReturnGeneric");
        Dog dog = WildcardEx.printAndReturnGeneric(dogBox);
        Cat cat = WildcardEx.printAndReturnGeneric(catBox);

        Animal dogBox1 = WildcardEx.printAndReturnWildcard(dogBox);
        Animal catBox1 = WildcardEx.printAndReturnWildcard(catBox);
    }
}
