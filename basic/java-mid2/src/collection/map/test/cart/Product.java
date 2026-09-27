package collection.map.test.cart;

import java.util.Objects;

public class Product {

    private String fruit;
    private int price;

    public Product(String fruit, int price) {
        this.fruit = fruit;
        this.price = price;
    }

    public String getFruit() {
        return fruit;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && Objects.equals(fruit, product.fruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruit, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "fruit='" + fruit + '\'' +
                ", price=" + price +
                '}';
    }
}
