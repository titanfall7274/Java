package annotation.mapping;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SimpleMapping {
    /// 요소를 하나만 가질 경우 애노테이션 사용 시 요소 이름을 생략할 수 있다.
    String value();
}
