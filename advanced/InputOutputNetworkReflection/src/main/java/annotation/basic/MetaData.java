package annotation.basic;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@AnnoMeta // METHOD / TYPE 적용 가능
public class MetaData {

//    @AnnoMeta // FIELD 에는 적용이 불가능 - 컴파일 오류
    private String id;

    @AnnoMeta // METHOD
    public void call() {

    }

    public static void main(String[] args) throws NoSuchMethodException {
        // // @annotation.basic.AnnoMeta() 출력은 모두 동일한다.
        Class<MetaData> metaDataClass = MetaData.class;
        AnnoMeta annoMeta = metaDataClass.getAnnotation(AnnoMeta.class);
        System.out.println("annoMeta = " + annoMeta);

        Method call = metaDataClass.getMethod("call");
        AnnoMeta annoMeta1 = call.getAnnotation(AnnoMeta.class);
        System.out.println("annoMeta1 = " + annoMeta1);


    }
}
