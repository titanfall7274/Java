package collection.set;

public class StringHashMain {

    static final int CAPACITY = 10;

    public static void main(String[] args) {
        // char
        char charA = 'A';
        char charB = 'B';
        System.out.println("charA = " + (int) charA); // 65
        System.out.println("charB = " + (int) charB); // 66

        System.out.println("hashCode('A') = " + hashCode("A"));
        System.out.println("hashCode('B') = " + hashCode("B"));
        System.out.println("hashCode('AB') = " + hashCode("AB"));

        System.out.println("hashIndex('A') = " + hashIndex(hashCode("A"))); // 65 % 10 = 5
        System.out.println("hashIndex('B') = " + hashIndex(hashCode("B"))); // 66 % 10 = 6
        System.out.println("hashIndex('AB') = " + hashIndex(hashCode("AB"))); // 131 % 10 = 1
    }

    private static int hashCode(String str) {
        char[] charArray = str.toCharArray();
        int sum = 0;
        for (char c : charArray) {
            sum += (int) c;
        }
        return sum;
    }

    private static int hashIndex(int value) {
        return value % CAPACITY;
    }
}
