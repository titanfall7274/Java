package annotation.mapping;

import java.lang.reflect.Method;

public class TestControllerMain{

    public static void main(String[] args) {
        TestController testController = new TestController();

        Class<? extends TestController> aClass = testController.getClass();

        // TestController에 선언된 메서드를 찾는다.
        for (Method method : aClass.getDeclaredMethods()) {
            // 리플렉션이 제공하는 getAnnotation() 메서드를 사용하여 붙어있는 애노테이션을 찾을 수 있다.
            SimpleMapping simpleMapping = method.getAnnotation(SimpleMapping.class);

            // simpleMapping이라는 어노테이션에 지정된 값을 조회할 수 있다.
            if (simpleMapping != null) {
                /// /site1 -> public void annotation.mapping.TestController.page1()
                /// / -> public void annotation.mapping.TestController.home()
                System.out.println(simpleMapping.value() + " -> " + method);
            }
        }
    }
}
