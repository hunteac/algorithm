import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String[] arr = a.split("");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(arr[i].toUpperCase())) // 대문자일 때
                System.out.print(arr[i].toLowerCase()); // 소문자로
            else  // 소문자일 때
                System.out.print(arr[i].toUpperCase()); // 대문자로
        }
    } 
}