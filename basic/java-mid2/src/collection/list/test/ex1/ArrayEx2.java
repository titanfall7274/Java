package collection.list.test.ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayEx2 {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            if(n == 0) break;

            numbers.add(n);
        }

        System.out.println("출력");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
            if(i < numbers.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
