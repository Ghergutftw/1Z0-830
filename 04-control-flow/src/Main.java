import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        enchantedSwitch();
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

    static void enchantedSwitch(){
        enum DAYS{MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY};

        int day = 3;
        String dayOfTheWeek = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 ->
            {
                System.out.println("The day is:");
                yield "Wednesday";
            }
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> throw new IllegalArgumentException("Invalid day!");
        };

        String isWeekday = switch (day){
            case 1,2,3,4,5 -> "Weekday";
            default -> "Weekend";
        };

        var message = switch (day){
            case 6,7 : yield "weeknd";
            default: yield "weekday";
        };

        System.out.println(dayOfTheWeek);
        System.out.println(isWeekday);

        //Pattern Matching

        Object object = 123;
        switch (object){
            case Integer i -> System.out.println("Is integer : " + i);
            case String s -> System.out.println("Is String : " + s);
            default -> System.out.println("Not an integer or string");
        }

        DAYS dayOfWeek = DAYS.WEDNESDAY;
        switch (dayOfWeek){
            case FRIDAY, SUNDAY -> System.out.println("Weekend");
            default -> System.out.println("Weekday");
        }

    }

}