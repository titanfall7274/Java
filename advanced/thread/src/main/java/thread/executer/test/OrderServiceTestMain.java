package thread.executer.test;

import java.util.concurrent.ExecutionException;

public class OrderServiceTestMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String orderNo = "Order#1234";

        OldOrderService orderService = new OldOrderService();
        orderService.order(orderNo);

        NewOrderService newOrderService = new NewOrderService();
        newOrderService.order(orderNo);
    }
}
