package collection.map.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ArrayToMapTest {

    public static void main(String[] args) {
        String[][] prodctArr = {{"java", "10000"}, {"Spring", "20000"}, {"JPA", "30000"}};

        // 주어진 배열로부터 Map 생성 - 코드 작성
        Map<String, Integer> hashMap = new HashMap<>();
        for (String[] strings : prodctArr) {
            hashMap.putIfAbsent(strings[0], Integer.valueOf(strings[1]));
        }

        // Map의 모든 데이터 출력 - 코드 작성
        Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println("key = " + key + ", value = " + value);
        }
    }
}
