package lamda.ex2;

public class ComposeExample {

    public static MyTransformer compose(MyTransformer f1, MyTransformer f2) {
        return new MyTransformer() {
            @Override
            public String compose(String message) {
                return f2.compose(f1.compose(message));
            }
        };
    }

    public static void main(String[] args) {
        MyTransformer myTransformer = compose(message -> message.toUpperCase(), message -> "***" + message + "***");
        String result = myTransformer.compose("hello lambda!");
        System.out.println("result = " + result);
    }
}
