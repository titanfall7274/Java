package collection.set.member;

import collection.set.MyHashSetV2;

public class HashAndEqualsMain2 {

    // 실행 환경에 따라 다른 hashCode가 나올수 있으며
    // 객체를 좀더 생성하는 등등에 따라 hashCode가 달라질 수 있습니다.
    public static void main(String[] args) {
        MyHashSetV2 set = new MyHashSetV2(10);

        // 중복 등록 - 논리적으로 같은 회원
        MemberOnlyHash m1 = new MemberOnlyHash("A"); // 65
        MemberOnlyHash m2 = new MemberOnlyHash("A"); // 65

        System.out.println("m1.hashCode() = " + m1.hashCode());
        System.out.println("m2.hashCode() = " + m2.hashCode());

        // HashCode는 Override하였지만 Equals는 Override 하지 않은 경우이다.
        // 둘은 서로 다른 같은 참조를 가지고있다.
        System.out.println("m1.equals(m2) = " + m1.equals(m2));

        // System.identityHashode(Object x)를 통해 ref를 출력해볼수있다.
/*
        System.ref(m1) = 317574433
        System.ref(m2) = 885284298
*/
        // 두 객체의 참조는 다른것을 확인해볼 수 있고 equals는 당연히 실패하게 된다.
        System.out.println("System.ref(m1) = " + System.identityHashCode(m1));
        System.out.println("System.ref(m2) = " + System.identityHashCode(m2));

        // set의 가장 기본적인 규칙은 중복을 허용하지 않으며 저장 순서를 보장하지 않는다는 것이다.
        // 그러나 m1이 들어가고 m2가 들어갈때 bucket.equals(value)를 할때 참조 값으로 비교를 하게 되고 비교에 실패하여 값이 그대로 들어가게 된다.
        set.add(m1); // 5
        set.add(m2); // 5
        System.out.println(set); // ['A', 'A']

        // 검색 실패
        MemberOnlyHash searchValue = new MemberOnlyHash("A"); // 65
//        System.identityHashCode(searchValue) = 932172204
        System.out.println("System.identityHashCode(searchValue) = " + System.identityHashCode(searchValue));
        System.out.println("searchValue.hashCode() = " + searchValue.hashCode());
        boolean contains = set.contains(searchValue);
        System.out.println("contains = " + contains);
    }
}
