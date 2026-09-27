package collection.set.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetOperationsTest {

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(List.of(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(List.of(3, 4, 5, 6, 7));

        // 두 집합의 합집합, 교집합, 차집합을 구하라. 출력 순서는 관계없다.

        // 1. 합집합
        HashSet<Integer> union = new HashSet<>();
        union.addAll(set1);
        union.addAll(set2);
        System.out.println("union = " + union);

        // 2. 교집합
        HashSet<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("intersection = " + intersection);

        // 3. 차집합
        HashSet<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);

        System.out.println("difference = " + difference);
        HashSet<Integer> dif2 = new HashSet<>(set2);
        dif2.removeAll(set1);
        System.out.println("dif2 = " + dif2);
    }
}
