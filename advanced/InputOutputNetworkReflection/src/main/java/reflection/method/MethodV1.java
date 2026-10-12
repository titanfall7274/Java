package reflection.method;

import reflection.data.BasicData;

import java.lang.reflect.Method;

public class MethodV1 {
    public static void main(String[] args) {
        Class<BasicData> helloClass = BasicData.class;

        System.out.println("===== methods() ======");
        Method[] methods = helloClass.getMethods();

        // 2개의 public 접근자 메서드와
        // Object 클래스의 equals, toString, hashCode, getClass()
        // wait 3종류, notify, notifyAll
        for (Method method : methods) {
            System.out.println("method = " + method);
        }

        System.out.println("====== declaredMethod() ======");
        Method[] declaredMethods = helloClass.getDeclaredMethods();

        // 실제로 선언한 메서드들만 출력됨
        // public, private, default, protected 접근제어자 메서드들
        for (Method declaredMethod : declaredMethods) {
            System.out.println("declaredMethod = " + declaredMethod);
        }
    }
}
