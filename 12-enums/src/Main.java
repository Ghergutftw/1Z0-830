import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a color: ");
        String inputColor = scanner.nextLine();
        try {
            Color color = Color.valueOf(inputColor.toUpperCase());

            switch (color) {
                case RED:
                    System.out.println("You entered red!");
                    break;
                case YELLOW:
                    System.out.println("You entered yellow!");
                    break;
                case GREEN:
                    System.out.println("You entered green!");
                    break;
            }
        }catch (IllegalArgumentException e){
            System.out.println("Please enter a valid color!" + Arrays.toString(Color.values()));
        }

    }
}