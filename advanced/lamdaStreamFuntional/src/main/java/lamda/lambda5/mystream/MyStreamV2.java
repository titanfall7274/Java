package lamda.lambda5.mystream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

// static factory 추가
public class MyStreamV2 {

    private List<Integer> internalList;

    // 외부에서 호출 불가
    private MyStreamV2(List<Integer> internalList) {
        this.internalList = internalList;
    }

    // static factory
    public static MyStreamV2 of(List<Integer> internalList) {
        return new MyStreamV2(internalList);
    }

    public MyStreamV2 filter(Predicate<Integer> predicate) {
        ArrayList<Integer> filtered = new ArrayList<>();

        for (Integer integer : internalList) {
            boolean passed = predicate.test(integer);
            if(passed) {
                filtered.add(integer);
            }
        }
        return MyStreamV2.of(filtered);
    }

    public MyStreamV2 map(Function<Integer, Integer> mapper) {
        List<Integer> mapped = new ArrayList<>();

        for (Integer integer : internalList) {
            mapped.add(mapper.apply(integer));
        }

        return MyStreamV2.of(mapped);
    }

    public List<Integer> toList() {
        return internalList;
    }
}
