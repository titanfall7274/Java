package collection.list.test.ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayEx3 {

    public static void main(String[] args) {
        ArrayList<Integer> students = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            if(n == 0) break;

            students.add(n);
        }
        
        int total = 0;
        for (int i = 0; i < students.size(); i++) {
            total += students.get(i);
        }

        double average = (double) total / students.size();
        System.out.println("점수 총합: " + total);
        System.out.println("점수 평균: " + average);
    }
}
