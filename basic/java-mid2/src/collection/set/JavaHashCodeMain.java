package collection.set;

import collection.set.member.Member;

public class JavaHashCodeMain {

    public static void main(String[] args) {
        // Object의 기본 hashCode는 객체의 참조값으 ㄹ기반으로 ㅅ애성
        Object obj1 = new Object();
        Object obj2 = new Object();

        /*
            obj1 = java.lang.Object@6acbcfc0
            obj2 = java.lang.Object@5b480cf9
        */
        System.out.println("obj1 = " + obj1);
        System.out.println("obj2 = " + obj2);

        /* 객체의 참조값을 그냥 hashCode로 사용한다.
            1791741888
            1531448569
        */
        System.out.println(Integer.toHexString(obj1.hashCode()));
        System.out.println(obj1.hashCode());
        System.out.println(Integer.toHexString(obj2.hashCode()));
        System.out.println(obj2.hashCode());

        // 각 클래스마다 hashCode를 미이 오버라이딩 해두었다.
        Integer i = 10;
        String strA = "A";
        String strAB = "AB";

        System.out.println("10.hashCode() = " + i.hashCode());
        System.out.println("strA.hashCode() = " + strA.hashCode());
        System.out.println("strAB.hashCode() = " + strAB.hashCode()); // 여러 문자의 경우 충돌하지 않도록 복잡한 작업을 통해 131 > ? > 2081

        // hashCode는 마이너스 값이 들어올 수 있다.
        System.out.println("Integer.valueOf(-1).hashCode() = " + Integer.valueOf(-1).hashCode());

        // 둘은 같을까? 인스턴스는 다르지만, equals는 갑다.
        Member member1 = new Member("idA");
        Member member2 = new Member("idA");

        System.out.println((member1 == member2)); // false
        System.out.println("idA.equals(idB) = " + member1.equals(member2)); // true

        // 두 객체의 id가 도일하여 hashCode() 반환값이 동일하다.
        // @Override HashCode를 제거하면 id값을 기준으로 참조겂을 만들지 않기때문에 다르게 나온다.
        System.out.println(member1.hashCode()); // 104070
        System.out.println(member2.hashCode()); // 104070

        //

    }
}
