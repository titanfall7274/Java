package collection.map.test;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencyTest {

    public static void main(String[] args) {
        String text = "orange banana apple apple banana apple";
        Map<String, Integer> hashMap = new HashMap<>();

        String[] words = text.split(" ");
        for (String word : words) {
            Integer count = hashMap.get(word);
            if (count == null) {
                count = 0;
            }
            count++;

            hashMap.put(word, count);
            // map.put(word, map.getOfDefault(word, 0) + 1);
        }

        System.out.println("words = " + hashMap);
    }
}
