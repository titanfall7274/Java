package generic.ex4;

import generic.animal.Animal;

public class AnimalMethod {

    // 반드시 타입 상한을 걸어야 Animal에 작성된 메서드들을 사용할 수 있다.
    public static <T extends Animal> void checkUp(T animal) {
        System.out.println("동물 이름: " + animal.getName());
        System.out.println("동물 크기: " + animal.getSize());
        animal.sound(); // override 된 Dog.sound() 호출
    }

    public static <T extends Animal> T bigger(T target1, T target2) {
        return target1.getSize() > target2.getSize() ? target1 : target2;
    }

}
