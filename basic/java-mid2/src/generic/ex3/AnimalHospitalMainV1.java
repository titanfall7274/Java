package generic.ex3;

import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalHospitalMainV1 {

    public static void main(String[] args) {
        AnimalHostpitalV1 dogHospital = new AnimalHostpitalV1();
        AnimalHostpitalV1 catHospital = new AnimalHostpitalV1();

        Dog dog = new Dog("멍멍이1", 100);
        Cat cat = new Cat("냐옹이1", 300);

        dogHospital.set(dog);
        dogHospital.checkUp();

        catHospital.set(cat);
        catHospital.checkUp();

        // 문제 1: 개 병원에 고양이 전달
        dogHospital.set(cat); // 매개변수 체크 실패: 컴파일 오류가 발생하지 않습니다.

        // 문제 2: 개 타입 반환
        dogHospital.set(dog);
        dogHospital.set(cat); // cat 의 size가 클경우 ClassCastException발생 가능
        Dog biggerDog = (Dog) dogHospital.bigger(new Dog("멍멍이2", 200));
        System.out.println("biggerDog = " + biggerDog);

        // 재사용 o, 타입 안정성 x
    }
}
