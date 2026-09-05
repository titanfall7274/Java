package thread.control;

import static util.ThreadUtils.sleep;

public class CheckedExceptionMain {

    public static void main(String[] args) throws Exception {
        throw new Exception();
    }

    static class CheckedRunnable implements Runnable {
        @Override
        public void run() /*throws Exception*/ {
            // throw new Exception; // 예외 던지기가 불가능합니다.


            // ThreadUtils.sleep(millis);
            sleep(1000);

//            try {
//                throw new Exception();
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
        }
    }
}
