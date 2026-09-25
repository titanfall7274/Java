package generic.test.ex3.unit;

// 클래스 생성 시점에 타입이 결정되므로 제네릭 클래스로 지정
// 타입 상한을 BioUnit으로 제한
public class Shuttle<T extends BioUnit> {

    private T unit;

    public void in(T unit) {
        this.unit = unit;
    }

    public void showInfo() {
        System.out.println("이름: " + unit.getName() + ", HP: " + unit.getHp());
    }

    public T out() {
        return unit;
    }
}
