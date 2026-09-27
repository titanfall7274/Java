package collection.map.test;

import java.util.ArrayList;
import java.util.Map;

public class ItemPriceTest {

    public static void main(String[] args) {
        Map<String, Integer> map = Map.of("사과", 500, "바나나", 500, "망고", 1000, "딸기", 1000);

        ArrayList<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1000)) {
                result.add(entry.getKey());
            }
        }

        System.out.println("result = " + result);
    }
}
