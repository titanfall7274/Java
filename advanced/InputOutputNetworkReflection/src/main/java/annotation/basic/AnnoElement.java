package annotation.basic;


import util.MyLogger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/// 애노테이션이란? 코드에 대한 추가적인 정보를 주석처럼 달아놓는다.
/// 단, 일반 주석과 달리, 애노테이션은 컴파일러나 런타임에서 해석될 수 있는 메타데이터를 제공한다.

// 애노테이션은 @interface 키워드로 정의한다.
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnoElement {
    // 요소는 메서드 형태로 정의되며 괄호를 포함하되 매개변수는 없어야합니다.
    String value();

    // 요소에 기본 값을 지정할 수 있습니다.
    int count() default 0;
    String[] tags() default {};

    // void를 반환 타입으로 사용할 수 없다.
//    void count2();

    // MyLogger data(); // 다른 타입은 적용이 불가능
    Class<? extends MyLogger> annoData() default MyLogger.class; // 클래스 정보는 가능

    // 예외를 선언할 수 없다.
//    ClassNotFoundException ex();
}
