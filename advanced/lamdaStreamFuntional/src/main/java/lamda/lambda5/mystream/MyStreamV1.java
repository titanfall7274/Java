package lamda.lambda5.mystream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStreamV1 {

    private List<Integer> internalList;

    public MyStreamV1(List<Integer> internalList) {
        this.internalList = internalList;
    }

    public MyStreamV1 filter(Predicate<Integer> predicate) {
        ArrayList<Integer> filtered = new ArrayList<>();

        for (Integer integer : internalList) {
            boolean passed = predicate.test(integer);
            if(passed) {
                filtered.add(integer);
            }
        }
        return new MyStreamV1(filtered);
    }

    public MyStreamV1 map(Function<Integer, Integer> mapper) {
        List<Integer> mapped = new ArrayList<>();

        for (Integer integer : internalList) {
            mapped.add(mapper.apply(integer));
        }

        return new MyStreamV1(mapped);
    }

    public List<Integer> toList() {
        return internalList;
    }
}
