import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        // Swap characters at positions 0 and 2 for both strings
        String swappedS1 = s1.charAt(2) + s1.substring(1, 2) + s1.charAt(0);
        String swappedS2 = s2.charAt(2) + s2.substring(1, 2) + s2.charAt(0);

        // Compare the swapped strings and print the larger one
        int comparison = swappedS1.compareTo(swappedS2);
        if (comparison > 0) {
            System.out.println(swappedS1);
        } else if (comparison < 0) {
            System.out.println(swappedS2);
        } else {
            System.out.println(swappedS1); // If equal, print any one of them
        }
    }
}