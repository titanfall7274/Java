package collection.array;

import java.util.Arrays;

public class ArrayMain2 {

    public static void main(String[] args) {
        int[] arr = new int[5]; // 0으로 초기화
        System.out.println("== index 입력: O(1) ==");
        arr[0] = 1;
        arr[1] = 2;
        System.out.println(Arrays.toString(arr));

        // 배열의 첫번째 위치에 추가
        // 기본 배열의 데이터를 한 칸씩 뒤로밀고 배열의 첫 번째 위치에 추가
        System.out.println("배열의 첫 번째 위치에 3 추가 O(n)");
        int value = 3;
        addFirst(arr, value);

        System.out.println(Arrays.toString(arr));

        // index 위치에 추가
        // 기본 배열의 데이터를 한 칸씩 뒤로밀고 배열의 첫 번째 위치에 추가
        System.out.println("배열의 index(2) 위치에 4 추가 O(n)");
        int index = 2;
        int value2 = 4;
        addAtIndex(arr, index, value2);
        System.out.println(Arrays.toString(arr));

        // 배열의 끝에 추가
        System.out.println("배열의 마지막 위치에 5 추가 O(1)");
        addLast(arr, 5);
        System.out.println(Arrays.toString(arr));
    }

    private static void addLast(int[] arr, int value) {
        arr[arr.length - 1] = value;
    }

    private static void addAtIndex(int[] arr, int index, int value) {
        for(int i = arr.length - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = value;
    }

    private static void addFirst(int[] arr, int newValue) {
        addAtIndex(arr, 0, newValue);
    }
}
