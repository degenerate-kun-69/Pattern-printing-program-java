import java.util.Scanner;
public class PatternGenerator {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.println("Welcome to Pattern Generator!");
       System.out.print("Enter pattern type (square, Right angled triangle, pyramid, circle, diamond,parallelogram, trapezium): ");
       String patternType = scanner.nextLine();//scans userIn
       System.out.print("Enter size of the pattern: ");
       int size = scanner.nextInt();//scans size
       scanner.nextLine(); // Consume newline
       System.out.print("Enter character to use: ");
       char character = scanner.nextLine().charAt(0);//to solve the issue of person entering multiple character, chooses first only
       //switch case implementation instead of if-else to reduce complexity
       switch(patternType.toLowerCase()) {
           case "circle":
               generateCirclePattern(size, character);
               break;
           case "square":
               generateSquarePattern(size, character);
               break;
           case "right angled triangle":
               generateTrianglePattern(size, character);
               break;
           case "pyramid":
               generatePyramidPattern(size, character);
               break;
           case "diamond":
               generateDiamondPattern(size, character);
               break;
           case "parallelogram":
               System.out.println("Do you want the patter to be hollow? (True/false)");
               boolean hollow = scanner.nextBoolean();
               System.out.println("Enter base");
               int base = scanner.nextInt();
               System.out.println("Enter Height");
               int height = scanner.nextInt();
               printParallelogram(base, height, hollow, character);
               break;
           case "trapezium":
               System.out.println("Do you want the patter to be hollow? (True/false)");
               boolean hollow2 = scanner.nextBoolean();
               System.out.println("Enter base");
               int base2 = scanner.nextInt();
               System.out.println("Enter Height");
               int height2 = scanner.nextInt();
               printTrapezium(base2, height2, hollow2, character);
               break;
            default:
                //case if input fails or wrong input
               System.out.println("Invalid pattern type entered. Please choose one of the given one.");
           }
       }
   public static void generateSquarePattern(int size, char character) {
       boolean Hollow;
       Scanner sc = new Scanner(System.in);
       System.out.println("Do you want the pattern to be hollow? (True/False)");
       Hollow = sc.nextBoolean();
       System.out.println("Generated Pattern:");
       if (!Hollow) {//check if they want hollow or not
           for (int i = 0; i < size; i++) {
               for (int j = 0; j < size; j++) {
                   System.out.print(character + "   ");
                   //loop to print an n*n block of given char
               }
               System.out.println();
            }
       } else {
           for (int i = 0; i < size; i++) {
               for (int j = 0; j < size; j++) {
                   if (i == 0 || i == size - 1 || j == 0 || j == size - 1) {
                       System.out.print(character + "   ");
                   } else {
                       System.out.print("    "); // Print spaces for hollow part
                   }
               }
               System.out.println();
           }
       }
   }
   public static void generateTrianglePattern(int size, char character) {
       boolean hollow;
       Scanner sc = new Scanner(System.in);
       System.out.println("Do you want the pattern to be hollow? (True/False)");
       hollow = sc.nextBoolean();
       System.out.println("Generated Pattern:");
       if (!hollow) {
            for (int i = 1; i <= size; i++) {
               for (int j = 1; j <= i; j++) {
                   System.out.print(character + " ");
               }
               System.out.println();
           }
       } else {
           for (int i = 1; i <= size; i++) {
               if (i == size || i == 1) {
                   for (int j = 1; j <= i; j++) {
                       System.out.print(character + " ");
                   }
               } else {
                   System.out.print(character + " ");
                   for (int j = 1; j <= i - 2; j++) {
                       System.out.print("  "); // Adjust spaces for the hollow part
                   }
                   System.out.print(character + " ");
               }
               System.out.println();
           }
       }
   }
   public static void generatePyramidPattern ( int size, char character){
           boolean Hollow ;
           Scanner sc = new Scanner(System.in);
           System.out.println("Do you want the pattern to be hollow? (True/False)");
           Hollow = sc.nextBoolean();
           System.out.println("Generated Pattern:");
           if (!Hollow) {
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
           for (i = 1; i <= size; i++) {
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
   private static void printTrapezium(int base, int height, boolean isHollow, char character) {
       for (int i = 0; i < height; i++) {
           for (int j = 0; j < i; j++) {
               System.out.print("  ");
           }
           for (int j = 0; j < base + i; j++) {
               if (isHollow && i > 0 && i < height - 1 && j > 0 && j < base + i - 1) {
                   System.out.print("   ");
               } else {
                   System.out.print(character + "  ");
               }
           }
           System.out.println();
       }
   }
   public static void generateCirclePattern(int size,char character){
           // not a perfect circle due to the console's rectangular characters.
           boolean Hollow ;
           Scanner sc = new Scanner(System.in);
           System.out.println("Do you want the pattern to be hollow? (True/False)");
           Hollow = sc.nextBoolean();
           System.out.println("Generated Pattern:");
           if (!Hollow) {
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
    private static void printParallelogram(int base, int height, boolean isHollow, char character) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j < base; j++) {
                if (isHollow && i > 0 && i < height - 1 && j > 0 && j < base - 1) {
                    System.out.print("   ");
                } else {
                    System.out.print(character + "  ");
                }
            }
            System.out.println();
        }
    }

    public static void generateDiamondPattern ( int size, char character){
           boolean Hollow ;
           Scanner sc = new Scanner(System.in);
           System.out.println("Do you want the pattern to be hollow? (True/False)");
           Hollow = sc.nextBoolean();
           System.out.println("Generated Pattern:");
           if (!Hollow) {
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
           int i, j, mid;
           if (size % 2 == 1)
               size++;
           mid = size / 2;
           for (i = 1; i <= mid; i++) {
               for (j = 1; j <= mid - i; j++)
                   System.out.print(" ");
               System.out.print(character);
               if (i != 1) {
                   for (j = 1; j <= 2 * i - 3; j++) {
                       System.out.print(" ");
                   }
                   System.out.print(character);
               }
               for (j = 1; j <= mid - i; j++)
                   System.out.print(" ");
               System.out.println();
           }
           for (i = mid + 1; i < size; i++) {
               for (j = 1; j <= i - mid; j++)
                   System.out.print(" ");
               if (i == size - 1) {
                   System.out.print(character);
               } else {
                   System.out.print(character);
                   for (j = 1; j <= 2 * (size - i) - 3; j++) {
                       System.out.print(" ");
                   }
                   System.out.print(character);
               }
              for (j = 1; j <= i - mid; j++)
                   System.out.print(" ");
               System.out.println();
      }
   }
}