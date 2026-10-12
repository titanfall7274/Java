package reflection.field;

import reflection.data.User;

import java.lang.reflect.Field;

public class FieldV2 {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        User user = new User("id1", "userA", 20);
        System.out.println("user.getName() = " + user.getName());


        Class<? extends User> aClass = user.getClass();
        Field nameField = aClass.getDeclaredField("name");

        // private String name 에 접근을 허용하고 호출이 가능
        nameField.setAccessible(true);
        nameField.set(user, "userB");
        System.out.println("user.getName() = " + user.getName());
    }
}
