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
        System.out.println("Sortare alfabetica char");
        System.out.println(Arrays.toString(charArray)); // [A, B, C, d, x, z]
                                                        // Se ia dupa codul ASCII

        Arrays.sort(array3);
        System.out.println("Sortare numerica");
        System.out.println(Arrays.toString(array3));

        System.out.println("Sortare string cu numere");
        String[] stringArray = new String[] { "3", "300", "20", "35", "37", "4", "70" };
        Arrays.sort(stringArray);
        System.out.println(Arrays.toString(stringArray));

        System.out.println("Sortare String cu Cuvinte");
        String[] stringArrays2 = new String[] { "Cow", "Bull", "cat", "deer" };
        Arrays.sort(stringArrays2);
        System.out.println(Arrays.toString(stringArrays2));

        System.out.println("Sortare String cu Cuvinte + Cifre");
        String[] stringArrays3 = new String[] { "Cow", "Bull", "cat", "deer", "123", "300", "12" };
        Arrays.sort(stringArrays3);
        System.out.println(Arrays.toString(stringArrays3));

    }
}
