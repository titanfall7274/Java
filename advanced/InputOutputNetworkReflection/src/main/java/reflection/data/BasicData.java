package reflection.data;

public class BasicData {

    public String publicField;
    private int privateField;

    // 1. public 생성자
    public BasicData() {
        System.out.println("BasicData.BasicData");
    }

    // 2. private 생성자 + 매개변수
    private BasicData(String data) {
        System.out.println("BasicData.BasicData: " + data);
    }

    // 3. public 메소드 call
    public void call() {
        System.out.println("BasicData.call");
    }

    // 4. public 메서드 hello
    public String hello(String str) {
        System.out.println("BasicData.hello");
        return str + " hello";
    }

    // 5. private method
    private void privateMethod() {
        System.out.println("BasicData.privateMethod");
    }

    // 6. default method;
    void defaultMethod() {
        System.out.println("BasicData.defaultMethod");
    }

    // 7. protected method
    protected void protectedMethod() {
        System.out.println("BasicData.protectedMethod");
    }
}
