package collection.set.member;

import collection.set.MyHashSetV2;

public class HashAndEqualsMain3 {

    // 실행 환경에 따라 다른 hashCode가 나올수 있으며
    // 객체를 좀더 생성하는 등등에 따라 hashCode가 달라질 수 있습니다.
    public static void main(String[] args) {
        MyHashSetV2 set = new MyHashSetV2(10);

        // 중복 등록 - 논리적으로 같은 회원
        Member m1 = new Member("A");
        Member m2 = new Member("A");

        System.out.println("m1.hashCode() = " + m1.hashCode()); // 65
        System.out.println("m2.hashCode() = " + m2.hashCode()); // 65
        System.out.println("m1.equals(m2) = " + m1.equals(m2)); // true

        // 서로 다른 객체
        /*
            System.ref(m1) = 2093176254
            System.ref(m2) = 1854731462
        */
        System.out.println("System.ref(m1) = " + System.identityHashCode(m1));
        System.out.println("System.ref(m2) = " + System.identityHashCode(m2));

        set.add(m1); // 5
        boolean result = set.add(m2);// false
        System.out.println("result = " + result);
        System.out.println(set); // ['A']

        // 검색 성공
        MemberOnlyHash searchValue = new MemberOnlyHash("A"); // 65
        // System.identityHashCode(searchValue) = 933699219
        System.out.println("System.identityHashCode(searchValue) = " + System.identityHashCode(searchValue));
        System.out.println("searchValue.hashCode() = " + searchValue.hashCode());
        boolean contains = set.contains(searchValue);
        System.out.println("contains = " + contains);

        // 충돌 가능 - 2112
        System.out.println("\"Aa\".hashCode() = " + "Aa".hashCode());
        System.out.println("\"BB\".hashCode() = " + "BB".hashCode());
    }
}
