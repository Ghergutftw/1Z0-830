package operators02;

public class Main {
    public static void main(String[] args) {
    }

    static void operators() {
        int a = 30;
        a /= 5;

        System.out.println("a = " + a);
        String s1 = "Dragos ";
        System.out.println("Boss " + s1);
    }

    static void bitwise() {
        byte a = 8;  // 1000 in binary
        byte b = 9;   // 1001 in binary

        System.out.println("a (binary) = " + Integer.toBinaryString(a));
        System.out.println("b (binary) = " + Integer.toBinaryString(b));

        System.out.println("AND (a & b) = " + (a & b) + " (binary: " + Integer.toBinaryString(a & b) + ")");
        System.out.println("OR  (a | b) = " + (a | b) + " (binary: " + Integer.toBinaryString(a | b) + ")");
        System.out.println("XOR (a ^ b) = " + (a ^ b) + " (binary: " + Integer.toBinaryString(a ^ b) + ")");
        System.out.println("NOT (~b) = " + (~b) + " (binary: " + Integer.toBinaryString(~b) + ")");
        System.out.println("SHIFT LEFT (a << 1) = " + (a << 1) + " (binary: " + Integer.toBinaryString(a << 1) + ")");
        System.out.println("SHIFT RIGHT (a >> 1) = " + (a >> 1) + " (binary: " + Integer.toBinaryString(a >> 1) + ")");
    }

    static void charOperators(){
        char A = 65;
        System.out.printf("%c = %d\n" , A , (int)A );
        System.out.println("Is letter : " + Character.isLetter(A) );
        System.out.println("Is digit : " + Character.isDigit(A) );

        char letter1 = 67; //C        
        char letter2 =(char) (letter1 - 2);

        System.out.println("Letter 1 : " + letter1);
        System.out.println("Letter 2 : " + letter2);
        System.out.println("Is before D : " + ((letter2 < 'D') == true ? "Este" : "Nu este") );

    }
}
