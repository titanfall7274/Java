package collection.set.member;

import collection.set.MyHashSetV2;

public class HashAndEqualsMain1 {

    // 실행 환경에 따라 다른 hashCode가 나올수 있으며
    // 객체를 좀더 생성하는 등등에 따라 hashCode가 달라질 수 있습니다.
    public static void main(String[] args) {
        MyHashSetV2 set = new MyHashSetV2(10);

        // 중복 등록 - 논리적으로 같은 회원
        MemberNoHashEq m1 = new MemberNoHashEq("A");
        MemberNoHashEq m2 = new MemberNoHashEq("A");

        System.out.println("m1.hashCode() = " + m1.hashCode());
        System.out.println("m2.hashCode() = " + m2.hashCode());

        // HashCode와 Equals를 Override 하지않고 Object가 제공하는 기능을 그대로 사용했다.
        // 둘은 서로 다른 참조를 가지고있고 당연히 동등성 비교에도 실패한다.
        System.out.println("m1.equals(m2) = " + m1.equals(m2));

        set.add(m1); // 7
        set.add(m2); // 8
        System.out.println(set);

        // 검색 실패 - 3번째에서 찾아야하는데 아무것도 없음
        // 설령 번호가 우연히 맞았다 하더라고 equals 비교에서 실패할것이다.
        MemberNoHashEq searchValue = new MemberNoHashEq("A");
        System.out.println("searchValue.hashCode() = " + searchValue.hashCode());
        boolean contains = set.contains(searchValue);
        System.out.println("contains = " + contains);
    }
}
