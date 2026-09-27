package collection.map.test.cart;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private final Map<Product, Integer> cartMap;

    public Cart() {
        cartMap = new HashMap<>();
    }

    public Cart(Map<Product, Integer> cart) {
        this.cartMap = cart;
    }

    public void add(Product fruit, int quantity) {
        int existingQuantity = cartMap.getOrDefault(fruit, 0);

        int newQuantity = existingQuantity + quantity;
        if (newQuantity <= 0) {
            cartMap.remove(fruit);
        } else {
            cartMap.put(fruit, newQuantity);
        }
    }

    public void printAll() {
        System.out.println("== 모든 상품 출력 ==");
        for (Product product : cartMap.keySet()) {
            System.out.println("상품: " + product + " 수량: " + cartMap.get(product));
        }
    }
}
