package annotation.java;

public class DeprecatedMain {

    public static void main(String[] args) {
        System.out.println("DeprecatedMain.main");

        DeprecatedClass deprecatedClass = new DeprecatedClass();

        // 실행이 안되진 않는다. - 컴파일 시점의 경고일 뿐
        deprecatedClass.call1();
        deprecatedClass.call2(); // IDE 경고
        deprecatedClass.call3(); // IDE 경고 (심각)
    }
}
