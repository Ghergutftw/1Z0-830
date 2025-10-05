package arrays03;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        multidimensionalArrays();
        // This line causes a compile error
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

    static void searchingArrays(){
        int[] array = new int[]{0,2,4,6,8};
        System.out.println(Arrays.binarySearch(array, 8) + " este pozitia elementului 8 care exista");
        System.out.println(Arrays.binarySearch(array, 7) + " este pozitia elementului 7 care exista");
    }

    static void multidimensionalArrays(){
        int[][] matrix = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };

        System.out.println("Deep String");
        System.out.println(Arrays.deepToString(matrix));
        System.out.println("Linii");
        System.out.println(Arrays.toString(matrix[0]));
        System.out.println(Arrays.toString(matrix[1]));
        System.out.println(Arrays.toString(matrix[2]));
    }
}
