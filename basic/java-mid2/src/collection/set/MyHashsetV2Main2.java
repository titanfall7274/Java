package collection.set;

import collection.set.member.Member;

public class MyHashsetV2Main2 {

    public static void main(String[] args) {
        MyHashSetV2 set = new MyHashSetV2(10);
        Member hi = new Member("hi");
        Member jpa = new Member("JPA"); // 대문자 주의!
        Member java = new Member("java");
        Member spring = new Member("spring");

        /*
            hi.hashCode() = 3329
            jpa.hashCode() = 73659
            java.hashCode() = 3254818
            spring.hashCode() = -895679987 >> Math.abs() 될것임!
        */
        System.out.println("hi.hashCode() = " + hi.hashCode());
        System.out.println("jpa.hashCode() = " + jpa.hashCode());
        System.out.println("java.hashCode() = " + java.hashCode());
        System.out.println("spring.hashCode() = " + spring.hashCode());

        set.add(hi); // 9
        set.add(jpa); // 9
        set.add(java); // 8
        set.add(spring); // 7

        // 검색
        Member searchValue = new Member("JPA");
        System.out.println("searchValue = " + searchValue);
        boolean result = set.contains(searchValue);
        System.out.println("set.contains(searchValue) = " + result);
    }
}
