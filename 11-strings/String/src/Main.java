import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        usefulMethods();
    }

    static void concatenation() {
        String str = "Hello";
        String str2 = new String("World");

        System.out.println(str + " " + str2);

        System.out.println(4 + 5 + "6");//4 + 5 = 9 -> 9 + "6" -> "96"
        System.out.println(4 + "5" + 6);//4 + "5" -> "45" + 6 -> "456"
        System.out.println("4" + 5 + 6);//"4" + 5 -> "45" + 6 -> "456"
    }

    static void equality(){
        // == (is equal to operator), equals()

        String s1 = new String("Hello Developers");
        String s2 = new String("Hello Developers");
        String s3 = "Hello Developers";
        String s4 = "Hello Developers";
        String s5 = "Hello" + " Developers";

        System.out.println("-------------- == (is equal to) operator ---------------");
        System.out.println(s1 == s2);//false
        System.out.println(s1 == s3);//false
        System.out.println(s1 == s4);//false
        System.out.println(s1 == s5);//false
        System.out.println(s2 == s3);//false
        System.out.println(s2 == s4);//false
        System.out.println(s2 == s5);//false
        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//true
        System.out.println(s4 == s5);//true

        //System.identityHashCode()
        System.out.println("ID of s1: " + System.identityHashCode(s1));
        System.out.println("ID of s2: " + System.identityHashCode(s2));
        System.out.println("ID of s3: " + System.identityHashCode(s3));
        System.out.println("ID of s4: " + System.identityHashCode(s4));
        System.out.println("ID of s5: " + System.identityHashCode(s5));

        //equals()
        System.out.println("-------------- equals() ---------------");
        System.out.println(s1.equals(s2));//true
        System.out.println(s1.equals(s3));//true
        System.out.println(s1.equals(s4));//true
        System.out.println(s1.equals(s5));//true
        System.out.println(s2.equals(s3));//true
        System.out.println(s2.equals(s4));//true
        System.out.println(s2.equals(s5));//true
        System.out.println(s3.equals(s4));//true
        System.out.println(s3.equals(s5));//true
        System.out.println(s4.equals(s5));//true


        System.out.println("-------------- Wrapper and primitive ---------------");
        //Wrapper and primitive
        Integer age1 = 20;
        int age2 = 20;

        System.out.println(age1 == age2);
        System.out.println(age1.equals(age2));


        System.out.println("-------------- Arrays ---------------");
        //Arrays
        String[] animals1 = new String[]{"Dog","Cat","Cow"};
        String[] animals2 = {"Dog","Cat","Cow"};
        String[] animals3 = new String[3];
        animals3[0] = "Dog";
        animals3[1] = "Cat";
        animals3[2] = "Cow";
        String[] animals4 = animals1;

        //For Arrays, each instance is a different object
        System.out.println("************* == ***************");
        System.out.println(animals1 == animals2);//false
        System.out.println(animals1 == animals3);//false
        System.out.println(animals1 == animals4);//true
        System.out.println(animals2 == animals3);//false
        System.out.println(animals2 == animals4);//false
        System.out.println(animals3 == animals4);//false

        //Uses the same as the object reference comparison (==), so the same as above
        System.out.println("************* equals() ***************");
        System.out.println(animals1.equals(animals2));//false
        System.out.println(animals1.equals(animals3));//false
        System.out.println(animals1.equals(animals4));//true
        System.out.println(animals2.equals(animals3));//false
        System.out.println(animals2.equals(animals4));//false
        System.out.println(animals3.equals(animals4));//false

        //Compares the contents of the arrays
        System.out.println("************* Arrays.equals() ***************");
        System.out.println(Arrays.equals(animals1,animals2));//true
        System.out.println(Arrays.equals(animals1,animals3));//true
        System.out.println(Arrays.equals(animals1,animals4));//true
        System.out.println(Arrays.equals(animals2,animals3));//true
        System.out.println(Arrays.equals(animals2,animals4));//true
        System.out.println(Arrays.equals(animals3,animals4));//true
    }

    static void immutability() {
        //The reason of the immutability it's because the String pool
        String str = "Hello";
        System.out.println("Original String: " + str);

        str.concat(" World");
        System.out.println("After concat (without assignment): " + str);

        str = str.concat(" World");
        System.out.println("After concat (with assignment): " + str);
    }

    static void usefulMethods() {

        String text = "  Hello World  ";
        String lower = "hello";
        String upper = "HELLO";

        // Lungime
        System.out.println("length: " + text.length());

        // Verificare empty
        System.out.println("isEmpty: " + "".isEmpty());

        // Trim & strip
        System.out.println("trim: '" + text.trim() + "'");
        System.out.println("strip: '" + text.strip() + "'");
        System.out.println("stripLeading: '" + text.stripLeading() + "'");
        System.out.println("stripTrailing: '" + text.stripTrailing() + "'");

        // Upper/Lower
        System.out.println("toLowerCase: " + upper.toLowerCase());
        System.out.println("toUpperCase: " + lower.toUpperCase());

        // equals & equalsIgnoreCase
        System.out.println("equals: " + lower.equals("hello"));
        System.out.println("equalsIgnoreCase: " + lower.equalsIgnoreCase(upper));

        // contains, startsWith, endsWith
        System.out.println("contains 'lo': " + lower.contains("lo"));
        System.out.println("startsWith 'he': " + lower.startsWith("he"));
        System.out.println("endsWith 'lo': " + lower.endsWith("lo"));

        // indexOf & lastIndexOf
        String t2 = "hello";
        System.out.println("indexOf 'l': " + t2.indexOf("l"));
        System.out.println("lastIndexOf 'l': " + t2.lastIndexOf("l"));

        // Substring
        System.out.println("substring (1,4): " + t2.substring(1, 4));

        // Replace & ReplaceAll
        System.out.println("replace: " + "a-b-c".replace("-", "_"));
        System.out.println("replaceAll: " + "a1b2c3".replaceAll("\\d", ""));

        // Split
        String[] parts = "a,b,c".split(",");
        System.out.println("split:");
        for (String p : parts) {
            System.out.println("  " + p);
        }

        // Join
        System.out.println("join: " + String.join(" | ", "A", "B", "C"));

        // Repeat
        System.out.println("repeat: " + "ha".repeat(3));

        // formatted
        System.out.println("formatted: " + "Hello %s!".formatted("Madalin"));

        // transform
        String result = "java21".transform(s -> s.toUpperCase() + "_ROCKS");
        System.out.println("transform: " + result);
    }

}