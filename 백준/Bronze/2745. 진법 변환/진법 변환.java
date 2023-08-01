import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        String s = sc.next();
        long b = sc.nextInt();
        long num = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            long digit;
            if (Character.isDigit(c)) {
                digit = c - '0';
            } else {
                digit = c - 'A' + 10;
            }
            num = num * b + digit;
        }
        System.out.println(num);
        sc.close();
        
    }
}