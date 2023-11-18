import java.util.Scanner;
//recursion based program, stack, queue, LL implement not applicable rn
public class PatternGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Pattern Generator!");
        //need to add more pattern types here
        System.out.print("Enter pattern type (square, triangle): ");
        String patternType = scanner.nextLine();

        System.out.print("Enter size of the pattern: ");
        int size = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter character to use: ");
        char character = scanner.nextLine().charAt(0);

        System.out.println("Generated Pattern:");
        if (patternType.equalsIgnoreCase("square")) {
            generateSquarePattern(size, character);
        } else if (patternType.equalsIgnoreCase("triangle")) {
            generateTrianglePattern(size, character);
        } else {
            System.out.println("Invalid pattern type entered. Please choose square or triangle.");
        }
    }
    //name methods only with "generate<pattern type>Pattern
    public static void generateSquarePattern(int size, char character) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(character + " ");
            }
            System.out.println();
        }
    }

    public static void generateTrianglePattern(int size, char character) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(character + " ");
            }
            System.out.println();
        }
    }
}
