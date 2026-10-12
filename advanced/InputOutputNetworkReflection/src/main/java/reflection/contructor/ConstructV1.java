package reflection.contructor;

import java.lang.reflect.Constructor;

public class ConstructV1 {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("reflection.data.BasicData");

        System.out.println("========= construtors() =========");
        Constructor<?>[] constructors = aClass.getConstructors();
        // constructor = public reflection.data.BasicData()
        for (Constructor<?> constructor : constructors) {
            System.out.println("constructor = " + constructor);
        }

        System.out.println("========= declaredConstrutors() =========");
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        // declaredConstructor = public reflection.data.BasicData()
        // declaredConstructor = private reflection.data.BasicData(java.lang.String)
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("declaredConstructor = " + declaredConstructor);
        }
    }
}
