package generic.test.ex3.unit;

public class UnitUtil {

    // 제네릭 클래스로 정의할 경우 만들때마다 UnitUtil 클래스를 만들고 maxHp를 호출해야한다.
    // 제네릭 메서드로 사용할 경우 메서드가 호출 될 때 타입을 지정하기때문에 UnitUtil.maxHp꼴로 호출이 가능하다.
    // 와일드 카드의 경우 상항을 지정하고 사용해야하는데 그럴경우 BioUnit이 반환되기때문에 사용이 불가능하다.
    public static <T extends BioUnit> T maxHp(T target1, T target2) {
        return target1.getHp() > target2.getHp() ? target1 : target2;
    }
}
