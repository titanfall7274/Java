package lamda.lambda5.map;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class GenericMapper {

    // 입력과 반환이 다르며,
    public static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        ArrayList<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(mapper.apply(t));
        }
        return result;
    }

}
