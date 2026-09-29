package lamda.lambda1;

public class LambdaSimple4 {

    public static void main(String[] args) {
        MyCall call1 = (int value) -> value * 2;
        System.out.println("call1.call(2) = " + call1.call(2));

        MyCall call2 = (value) -> value * 2;
        System.out.println("call2.call(3) = " + call2.call(3));

        MyCall call3 = value -> value * 2;
        System.out.println("call3.call(4) = " + call3.call(4));
    }
}
