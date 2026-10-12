package reflection.field;

import reflection.data.BasicData;

import java.lang.reflect.Field;

public class FieldV1 {

    public static void main(String[] args) {
        Class<BasicData> helloClass = BasicData.class;

//        fields() : 해당 클래스와 상위 클래스에서 상속된 모든 public 필드를 반환
        System.out.println("====== fields() ======");
        Field[] fields = helloClass.getFields();
        // field = public java.lang.String reflection.data.BasicData.publicField
        for (Field field : fields) {
            System.out.println("field = " + field);
        }

//        declaredFields() : 해당 클래스에서 선언된 모든 필드를 반환하며,
//        접근 제어자에 관계없이 반환. 상속된 필드는 포함하지 않음
        System.out.println("====== declaredFields() =======");
        Field[] declaredFields = helloClass.getDeclaredFields();
//        declaredField = public java.lang.String reflection.data.BasicData.publicField
//        declaredField = private int reflection.data.BasicData.privateField
        for (Field declaredField : declaredFields) {
            System.out.println("declaredField = " + declaredField);
        }
    }
}
