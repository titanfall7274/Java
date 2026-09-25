package generic.ex3;

public class AnimalHostpitalV2<T> {

    private T animal;

    public void set(T animal) {
        this.animal = animal;
    }

    public void checkUp() {
        // 컴파일 에러 발생
        // T의 타입을 메서드를 장의하는 시점에는 알 수 없다. Object의 기능만 사용
        animal.toString();
        animal.equals(null);

//        System.out.println("동물 이름: " + animal.getName());
//        System.out.println("동물 크기: " + animal.getSize());
//        animal.sound(); // override 된 Dog.sound() 호출
    }

    public T bigger(T target) {
//        return animal.getSize() > target.getSize() ? animal : target;
        return null;
    }
}
