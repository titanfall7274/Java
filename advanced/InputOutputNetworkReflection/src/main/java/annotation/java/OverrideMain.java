package annotation.java;

public class OverrideMain {

    static class A {
        public void call() {
            System.out.println("A.call");
        }
    }

    static class B extends A {

        // 오타시 이렇게 컴파일 에러를 발생시킨다.
        // Method does not override method from its superclass
        @Override // FIELD / SOURCE - 컴파일시 날라간다.
        public void call() {
            System.out.println("B.call");
        }
    }

    public static void main(String[] args) {
        A a = new B();
        a.call();
    }
}
