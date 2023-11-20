import java.util.Scanner;

public class PatternGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Pattern Generator!");
        System.out.print("Enter pattern type (square, triangle, star, circle, diamond): ");
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
        } else if (patternType.equalsIgnoreCase("star")) {
            generateStarPattern(size, character);
        } else if (patternType.equalsIgnoreCase("circle")) {
            generateCirclePattern(size, character);
        } else if (patternType.equalsIgnoreCase("diamond")) {
            generateDiamondPattern(size, character);
        } else {
            System.out.println("Invalid pattern type entered. Please choose square, triangle, star, circle, or diamond.");
        }
    }

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

    public static void generateStarPattern(int size, char character) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void generateCirclePattern(int size, char character) {
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= size; j++) {
                if (Math.pow(i - size / 2.0, 2) + Math.pow(j - size / 2.0, 2) <= Math.pow(size / 2.0, 2)) {
                    System.out.print(character + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void generateDiamondPattern(int size, char character) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(character + " ");
            }
            System.out.println();
        }
        for (int i = size - 2; i >= 0; i--) {
            for (int j = 0; j < size - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(character + " ");
            }
            System.out.println();
        }
    }
}
