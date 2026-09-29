package lamda.ex1;

public class M1Before {

    public static void main(String[] args) {
        greetMorning();
        greetAfternoon();
        greetEvening();
    }

    private static void greetMorning() {
        System.out.println("=== 시작 ===");
        System.out.println("Good Morning!");
        System.out.println("=== 끝 ===");
    }
    private static void greetAfternoon() {
        System.out.println("=== 시작 ===");
        System.out.println("Good Afternoon!");
        System.out.println("=== 끝 ===");
    }
    private static void greetEvening() {
        System.out.println("=== 시작 ===");
        System.out.println("Good Evening!");
        System.out.println("=== 끝 ===");
    }
}
