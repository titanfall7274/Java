package network.tcp.autocloseable;

public class ResourceCloseMainV1 {

    public static void main(String[] args) {

        try {
            logic();
        } catch (CallException e) {
            throw new RuntimeException("CallException 예외 처리");
        } catch (CloseExecption e) {
            throw new RuntimeException("CloseException 예외 처리");
        }
    }

    private static void logic() throws CallException, CloseExecption {

        ResourceV1 resource1 = new ResourceV1("resource1");
        ResourceV1 resource2 = new ResourceV1("resource2");

        resource1.call();
        resource1.callEx(); // CallException >> 자원이 미처 정리되지 못함

        System.out.println("자원 정리"); // 호출 불가능

        // 자원을 닫는곳이라 가정
        resource2.closeEx();
        resource1.closeEx();
    }
}
