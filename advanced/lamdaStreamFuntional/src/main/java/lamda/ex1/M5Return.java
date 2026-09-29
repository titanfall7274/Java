package lamda.ex1;

import lamda.MyFunction;

public class M5Return {

    public static void main(String[] args) {
        MyFunction add = (a, b) -> a + b;
        System.out.println("add.apply(1, 2) = " + add.apply(1, 2));
        MyFunction sub = (a, b) -> a - b;
        System.out.println("sub.apply(3, 2) = " + sub.apply(3, 2));
        MyFunction xxx = (a, b) -> 0;
        System.out.println("xxx.apply(2, 3) = " + xxx.apply(2, 3));

        MyFunction add1 = getOperator("add");
        System.out.println("add1.apply(1, 2) = " + add1.apply(1, 2));

        MyFunction sub1 = getOperator("sub");
        System.out.println("sub1.apply(3, 2) = " + sub1.apply(3, 2));

        MyFunction xxx1 = getOperator("xxx");
        System.out.println("xxx1.apply(4, 2) = " + xxx1.apply(4, 2));

    }

    private static MyFunction getOperator(String operator) {
        switch (operator) {
            case "add":
                return (a, b) -> a + b;
            case "sub":
                return (a, b) -> a - b;
            default:
                return (a, b) -> 0;
        }
    }
}
