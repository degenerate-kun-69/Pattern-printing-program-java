import java.util.Scanner;

public class PatternGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Pattern Generator!");
        System.out.print("Enter pattern type (square, Right angled triangle, pyramid, circle, diamond): ");
        String patternType = scanner.nextLine();
        System.out.print("Enter size of the pattern: ");
        int size = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter character to use: ");
        char character = scanner.nextLine().charAt(0);

        if (patternType.equalsIgnoreCase("square")) {
            generateSquarePattern(size, character);
        } else if (patternType.equalsIgnoreCase("Right angled triangle")) {
            generateTrianglePattern(size, character);
        } else if (patternType.equalsIgnoreCase("Pyramid")) {
            generatePyramidPattern(size, character);
        } else if (patternType.equalsIgnoreCase("circle")) {
            generateCirclePattern(size, character);
        } else if (patternType.equalsIgnoreCase("diamond")) {
            generateDiamondPattern(size, character);
        } else {
            System.out.println("Invalid pattern type entered. Please choose square, triangle, star, circle, or diamond.");
        }
    }

//    public static void generateSquarePattern(int size, char character) {
//        boolean Hollow = false;
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Do you want the pattern to be hollow? (True/False)");
//        Hollow = sc.nextBoolean();
//        System.out.println("Generated Pattern:");
//        if (Hollow == false) {
//            for (int i = 0; i < size; i++) {
//                for (int j = 0; j < size; j++) {
//                    System.out.print(character + " ");
//                }
//                System.out.println();
//            }
//        }
//
//    }
public static void generateSquarePattern(int size, char character) {
    boolean Hollow = false;
    Scanner sc = new Scanner(System.in);
    System.out.println("Do you want the pattern to be hollow? (True/False)");
    Hollow = sc.nextBoolean();
    System.out.println("Generated Pattern:");

    if (!Hollow) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(character + " ");
            }
            System.out.println();
        }
    } else {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || i == size - 1 || j == 0 || j == size - 1) {
                    System.out.print(character + " ");
                } else {
                    System.out.print("  "); // Print spaces for hollow part
                }
            }
            System.out.println();
        }
    }
}


    public static void generateTrianglePattern(int size, char character) {
        boolean Hollow = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want the pattern to be hollow? (True/False)");
        Hollow = sc.nextBoolean();
        System.out.println("Generated Pattern:");
        if (Hollow == false) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j <= i; j++) {
                    System.out.print(character + " ");
                }
                System.out.println();
            }
        }
    }

    public static void generatePyramidPattern(int size, char character) {
        boolean Hollow = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want the pattern to be hollow? (True/False)");
        Hollow = sc.nextBoolean();
        System.out.println("Generated Pattern:");
        if(Hollow == false) {
            for (int i = 0; i < size; i++) {
                for (int j = size; j > i + 1; j--) {
                    System.out.print(" ");
                }
                for (int j = 0; j <= i; j++) {
                    System.out.print(character + " ");
                }
                System.out.println();
            }
        }

            int i, j, k = 0;
            for (i = 1; i <= size; i++)
            {

                for (j = i; j < size; j++) {
                    System.out.print(" ");
                }

                while (k != (2 * i - 1)) {
                    if (k == 0 || k == 2 * i - 2)
                        System.out.print(character);
                    else
                        System.out.print(" ");
                    k++;
                }
                k = 0;
                System.out.println();
            }
            for (i = 0; i < 2 * size - 1; i++) {
                System.out.print(character);
            }

    }


    public static void generateCirclePattern(int size, char character) {
        // This is a basic implementation. It may not be a perfect circle due to the console's rectangular characters.
        boolean Hollow = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want the pattern to be hollow? (True/False)");
        Hollow = sc.nextBoolean();
        System.out.println("Generated Pattern:");
        if(Hollow == false) {
            for (int i = 0; i <= size * 2; i++) {
                for (int j = 0; j <= size * 2; j++) {
                    int distance = (int) Math.sqrt(Math.pow(i - size, 2) + Math.pow(j - size, 2));
                    if (distance <= size) {
                        System.out.print(character + " ");
                    } else {
                        System.out.print("  "); // Two spaces for better visual representation
                    }
                }
                System.out.println();
            }
        }
    }


    public static void generateDiamondPattern(int size, char character) {
        boolean Hollow = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want the pattern to be hollow? (True/False)");
        Hollow = sc.nextBoolean();
        System.out.println("Generated Pattern:");
        if (Hollow == false) {
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
        int i,j,mid;
        if(size%2==1) //when n is odd, increase it by 1 to make it even
            size++;
        mid = size/2;

        // upper half pattern
        for(i = 1; i<= mid; i++) {
            for(j = 1; j<=mid-i; j++) //print the blank spaces and outer box before star
                System.out.print(" ");

            if(i == 1) {
                System.out.print(character);
            }else{
                System.out.print(character); //in each line star at start and end position
                for(j = 1; j<=2*i-3; j++) { //print space to make hollow
                    System.out.print(" ");
                }
                System.out.print(character);
            }
            for(j = 1; j<=mid-i; j++) //print the blank spaces and outer box after star
                System.out.print(" ");

            System.out.println();
        }

        // lower half pattern
        for(i = mid+1; i<size; i++) {

            for(j = 1; j<=i-mid; j++) //print the blank spaces and outer box before star
                System.out.print(" ");

            if(i == size-1) {
                System.out.print(character);
            }else{
                System.out.print(character); //in each line star at start and end position
                for(j = 1; j<=2*(size - i)-3; j++) { //print space to make hollow
                    System.out.print(" ");
                }
                System.out.print(character);
            }
            for(j = 1; j<=i-mid; j++) //print the blank spaces and outer box after star
                System.out.print(" ");

            System.out.println();
        }


    }
}

