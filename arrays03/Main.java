package arrays03;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        sortingArrays();
    }

    static void initArrays() {
        int[] array = new int[5];
        int[] array2 = { 1, 2, 3, 4, 5 };
        int[] array3 = new int[] { 1, 3, 4, 5, 6, 7, 4, 3, 2 };
        array[0] = 5;
        array[1] = 2;

        System.out.println("Sum : " + (array[0] + array[1]));

        Object[] mixedArrays = new Object[] { 2, 4.7F, 0x12, "Hello", 'A', null };
    }

    static void sortingArrays() {
        int[] array = new int[5];
        int[] array2 = { 1, 2, 3, 4, 5 };
        int[] array3 = new int[] { 1, 13, 9, 3, 4, 5, 6, 7, 4, 3, 2 };
        array[0] = 5;
        array[1] = 2;
        Object[] mixedArrays = new Object[] { 2, 4.7F, 0x12, "Hello", 'A', null };

        char[] charArray = new char[] { 'z', 'B', 'A', 'd', 'C', 'x' };
        Arrays.sort(charArray);
        System.out.println("Sortare alfabetica");
        System.out.println(Arrays.toString(charArray));

        Arrays.sort(array3);
        System.out.println("Sortare numerica");
        System.out.println(Arrays.toString(array3));

    }
}
