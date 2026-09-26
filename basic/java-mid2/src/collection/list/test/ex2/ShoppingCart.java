package collection.list.test.ex2;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> shoppingCart;

    public ShoppingCart() {
        this.shoppingCart = new ArrayList<>();
    }

    public void add(Item item) {
        shoppingCart.add(item);
    }

    public void displayItems() {
        int totalPrice = 0;

        System.out.println("장바구니 상품 출력");
        for (int i = 0; i < shoppingCart.size(); i++) {
            Item item = shoppingCart.get(i);
            int total = item.getPrice() * item.getQuantity();
            totalPrice += total;
            System.out.println("상품명: " + item.getName() + ", 합계: " + total);

        }

        System.out.println("전체 가격 합: " + totalPrice);
    }

}
