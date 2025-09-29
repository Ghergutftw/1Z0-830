import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        conversionCasting();
    }

    static void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        System.out.println("You entered: " + number);
    }

    static void output(){
        System.out.println("Ceva");
        System.out.print("Enter a number: ");
        System.out.printf("Ceva frumos %S", "Bianca");
    }

    static void variables(){
        int a=10 , b=20;
        System.out.println("sum = " + (a+b)); //a+b fara paranteza e considerat
        //inca un element dintr-un array de string-uri
        System.out.println(a+b);
    }

    static void dataTypes(){
        boolean a = true;
        char b= 'r';
        byte c = 122;
        short d = 32;
        int e = 456;
        long f = 1234567890L;
        float g = 987654321.3123F;
        double h = 987654321.23443132431F;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);

        String str1 = "This is a string";
        System.out.println("str1 = " + str1);

        // For better readability
        long money = 987_654_321_98L;

        float float1 = 321_321.312F;
    }

    static void numbers(){
        int decimal = 13;
        int binary = 0b1101;
        int hexa = 0xD;
        int octal = 015;

        System.out.println("decimal = " + decimal);
        System.out.println("binary = " + binary);
        System.out.println("hexa = " + hexa);
        System.out.println("octal = " + octal);
        /*
        La afisare se poate observa ca toate valorile sunt convertite in base10
        decimal = 13
        binary = 13
        hexa = 13
        octal = 13
         */
        System.out.println("Valoarea in binar a dec + binar + hexa = " + Integer.toBinaryString(decimal+binary+hexa));
    }

    static void conversionCasting(){
        int a = 124;
        long b = a;
        double d = b;

        System.out.println("int value : " + a);
        System.out.println("long value : " + b);
        System.out.println("double value : " + d);



        double db2 = 135.35;
        long lng = (long)db2; //mergi de la un floating type la un int type, si pierzi date
                              //deci trebuie truncat
        byte by = (byte) a;
        System.out.println("long value : " + lng);

    }

    static void test(){
        class Customer {
            // instance variables
            private String firstName;
            private String lastName;

            // method to get full name from user
            public String getFullName() {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Enter first name: ");
                firstName = scanner.nextLine();

                System.out.print("Enter last name: ");
                lastName = scanner.nextLine();

                return firstName + " " + lastName;
            }

            // main method to test
            public static void main(String[] args) {
                Customer customer = new Customer();
                String fullName = customer.getFullName();
                System.out.println("Full name: " + fullName);
            }
        }

    }
}