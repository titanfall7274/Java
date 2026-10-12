package reflection.data;

public class BasicV1 {

    public static void main(String[] args) throws ClassNotFoundException {
        // 클래스 메타데이터 조회 방법 3가지
        Class<BasicData> basicDataClass1 = BasicData.class;
        System.out.println("basicDataClass1 = " + basicDataClass1);

        // 확장자를 BasicData를 사용하여 자식 타입도 하용한다.
        BasicData basicInstance = new BasicData();
        Class<? extends BasicData> basicDataClass2 = basicInstance.getClass();
        System.out.println("basicDataClass2 = " + basicDataClass2);

        // 이걸 활용하면 콘솔에서 사용자 입력만으로 원하는 클래스를 동적으로 찾을 수 있다.
        String className = "reflection.data.BasicData";
        Class<?> basicDataClas3 = Class.forName(className);
        System.out.println("basicDataClass3 = " + basicDataClas3);

        // 근데 그래서 이걸로 뭘 할수 있다는 것인가? 왜 필요한가?
        // BasicV2에서 계속
    }
}
