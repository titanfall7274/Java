package generic.ex3;

import generic.animal.Animal;

// 타입 매개변수 상한을 사용하여 타입을 제한하여 타입 안정성을 만족할 수 있습니다.
public class AnimalHostpitalV3<T extends Animal> {

    private T animal;

    public void set(T animal) {
        this.animal = animal;
    }

    public void checkUp() {
        System.out.println("동물 이름: " + animal.getName());
        System.out.println("동물 크기: " + animal.getSize());
        animal.sound(); // override 된 Dog.sound() 호출
    }

    public T bigger(T target) {
        return animal.getSize() > target.getSize() ? animal : target;
    }
}
