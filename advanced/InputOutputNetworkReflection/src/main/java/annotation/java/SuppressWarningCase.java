package annotation.java;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SuppressWarningCase {

    @SuppressWarnings("unused")
    public void unusedWarning() {
        int unusedVariable = 10; // 사용되지 않는 변수 경고 억제
    }

    @SuppressWarnings("deprecation")
    public void deprecatedMethod() {
        // 더 이상 사용되지 않는 메서드 호출
        java.util.Date date = new java.util.Date();

        //@Deprecated
        //    public int getDate() {
        //        return normalize().getDayOfMonth();
        //    }
        int date1 = date.getDate();
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public void uncheckedCast() {
        // 제네릭 타입 캐스팅 경고 억제, raw type 사용 경고
        // Raw use of parameterized class 'ArrayList'
        List list = new ArrayList();

        // 제네릭 타입과 관련된 unchecked 경고
        // Unchecked assignment: 'java.util.List' to 'java.util.List<java.lang.String>'
        List<String> stringList = list;
    }

    @SuppressWarnings("all")
    public void suppressAllWarning() {
        // 모든 경고 억제
        Date date = new Date();

        date.getDate();

        List list = new ArrayList();
        List<String> stringList = (List<String>) list;
    }
}
