package lamda.ex1;

public class M2After {

    public static void main(String[] args) {
        print(10, "kg");
        print(200, "kg");
        print(50, "g");
        print(40, "G");
    }

    private static void print(int weight, String unit) {
        System.out.println("무게: " + weight + unit);
    }
}
