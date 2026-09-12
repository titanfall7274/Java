package network.tcp.autocloseable;

public class ResourceCloseMainV4 {

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

        try (ResourceV2 resource1 = new ResourceV2("resource1");
             ResourceV2 resource2 = new ResourceV2("resource2");) {
            resource1.call();
            resource1.callEx();

        } catch (CloseExecption e) {
            System.out.println("CloseException: " + e);
            throw e;
        } catch (CallException e) {
            System.out.println("CallException:" + e);
            throw e;
        }
        // @Override close()
    }
}
