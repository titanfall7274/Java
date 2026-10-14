package annotation.basic.inherited;

import java.lang.annotation.Annotation;

public class InheritedMain {

    public static void main(String[] args) {

        // - InheritedAnnotation
        // - NoInheritedAnnotation
        print(Parent.class);

        // - InheritedAnnotation
        print(Child.class);

        // - InheritedAnnotation
        // - NoInheritedAnnotation
        print(TestInterface.class);

        // empty
        print(TestInterfaceImpl.class);

        /// 그럼 왜 @Inherited는 클래스 상속에만 지원되는가?
        /// 클래스 상속은 자식 클래스가 부모 클래스의 속성과 메서드를 상속받는다.
        /// 즉 자식 클래스는 부모 클래스의 특성을 이어 받으므로, 부모 클래스에 정의된 애노테이션을 자식 클래스가 자동으로 상속받을 수 있는 논리적 기반이 있다.

        /// 인터페이스는 메서드의 시그니처만 정의할 뿐, 상태나 행위를 가지지 않기 때문에, 인터페이스의 구현체가 애노테이션을 상속한다는 개념이 잘 맞지 않는다.

        /// 인터페이스와 다중 구현, 다이아몬드 문제
        /// 인터페이스는 상속과 달리 다중 구현이 가능하다. 때문에 여러 인터페이스간의 애노테이션 간의 충돌이나 모호한 상황이 발생할 수 있다.
    }

    private static void print(Class<?> clazz) {
        System.out.println("class: " + clazz) ;

        for (Annotation annotation : clazz.getAnnotations()) {
            System.out.println(" - " + annotation.annotationType().getSimpleName());
        }
        System.out.println();
    }
}
