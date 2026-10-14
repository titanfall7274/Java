package annotation.mapping;

public class TestController {

    // !! 애노테이션은 프로그램 코드가 아니다.
    // 주석과 비슷하지만, 리플렉션 같은 기술로 실행 시점에 읽어서 활용할 수 있는 특별한 주석
    @SimpleMapping(value = "/")
    public void home() {
        System.out.println("TestController.home");
    }

    @SimpleMapping("/site1")
    public void page1() {
        System.out.println("TestController.page1");
    }
}
