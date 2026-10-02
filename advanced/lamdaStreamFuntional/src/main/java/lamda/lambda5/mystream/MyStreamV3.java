package lamda.lambda5.mystream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

// Generic 추가
public class MyStreamV3<T> {

    private List<T> internalList;

    // 외부에서 호출 불가
    private MyStreamV3(List<T> internalList) {
        this.internalList = internalList;
    }

    // static factory << ! 반드시 제네릭 메서드로 선언하여야함 !
    public static <T> MyStreamV3<T> of(List<T> internalList) {
        return new MyStreamV3<>(internalList);
    }

    public MyStreamV3<T> filter(Predicate<T> predicate) {
        ArrayList<T> filtered = new ArrayList<>();

        for (T integer : internalList) {
            boolean passed = predicate.test(integer);
            if(passed) {
                filtered.add(integer);
            }
        }
        return MyStreamV3.of(filtered);
    }

    public <R> MyStreamV3<R> map(Function<T, R> mapper) {
        List<R> mapped = new ArrayList<>();

        for (T element : internalList) {
            mapped.add(mapper.apply(element));
        }

        return MyStreamV3.of(mapped);
    }

    public List<T> toList() {
        return internalList;
    }

    // 추가
    public void forEach(Consumer<T> consumer) {
        for (T element : internalList) {
            consumer.accept(element);
        }
    }
}
