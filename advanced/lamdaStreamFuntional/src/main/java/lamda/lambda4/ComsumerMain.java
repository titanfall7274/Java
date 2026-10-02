package lamda.lambda4;

import java.util.function.Consumer;

public class ComsumerMain {

    public static void main(String[] args) {
        Consumer<String> stringConsumer = new Consumer<>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        stringConsumer.accept("hello");

        // 람다
        Consumer<String> stringConsumer1 = s -> System.out.println(s);
        stringConsumer1.accept("hello");
    }
}
