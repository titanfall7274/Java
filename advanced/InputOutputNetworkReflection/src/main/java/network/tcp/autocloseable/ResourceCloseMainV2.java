package network.tcp.autocloseable;

public class ResourceCloseMainV2 {

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
        ResourceV1 resource1 = null;
        ResourceV1 resource2 = null;

        try {
            resource1 = new ResourceV1("resource1");
            resource2 = new ResourceV1("resource2");
            resource1.call();
            resource1.callEx(); // CallException
        } catch (CallException e) {
            System.out.println("ex: " + e);
            throw e;
        } finally {
            if(resource2 != null) {
                resource2.closeEx(); // ctrl alt t > try catch
            }

            if(resource1 != null) {
                resource1.closeEx(); // .try >> surround with try catch
            }
        }

    }
}
