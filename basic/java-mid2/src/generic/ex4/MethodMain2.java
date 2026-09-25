package generic.ex4;

import generic.animal.Cat;
import generic.animal.Dog;

public class MethodMain2 {

    public static void main(String[] args) {
        Dog dog = new Dog("멍멍이1", 100);
        Cat cat = new Cat("냐옹이1", 300);

        // @NotNull T animal
//        AnimalMethod.<Dog>checkUp(dog);
        AnimalMethod.checkUp(dog);
//        AnimalMethod.<Cat>checkUp(cat);
        AnimalMethod.checkUp(cat);

        Dog targetDog = new Dog("큰멍멍이", 200);
        Dog bigger = AnimalMethod.bigger(dog, targetDog);
        System.out.println("bigger = " + bigger);
    }
}
