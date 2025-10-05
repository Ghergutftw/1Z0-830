import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        forLoop();
    }

    static void ifMethod(){
        int a = 10 , b = 9;
        int c = a == b ? ++a: --b;

        System.out.println("a == " + a);
        System.out.println("b == " + b);
        System.out.println("c == " + c);

    }

    static void switchMethod(){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        switch (a){
            case 1:
                System.out.println("Entered one");
                break;
            case 2:
                System.out.println("Entered two");
                break;
            case 3:
                System.out.println("Entered three");
                break;
            default:
                System.out.println("Default");
        }

        switch (a){
            case 1: case 3: case 5:
                System.out.println("Odd");
                break;
            case 2: case 4:case 6:
                System.out.println("Even");
                break;
        }
    }

    static void forLoop(){
        int[] nums = new int[]{1,2,3,4,5,6,7};
        for (int num : nums) {
            System.out.println(num);
        }

        String nume = "Bianca";
        char[] numeCharArray = nume.toCharArray();

        outter:
        for (char c : numeCharArray) {
            System.out.print(c);
            inner:
            for(int j=0;j<numeCharArray.length;j++){
                System.out.print(numeCharArray[j]);
            }
        }


    }

}