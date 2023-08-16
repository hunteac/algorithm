import java.util.Scanner;
import java.util.Stack;
 
class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int k = sc.nextInt();
            int sum = 0; // 받아 적은 수의 총합을 위한 변수 선언 및 초기화
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < k; i++) {
                int n = sc.nextInt();
                if (n != 0) // 0이 아니면 받아 적기
                    stack.push(n);
                else // 0이면 최근에 쓰고 지우지 않았던 수를 지우기
                    stack.pop();
            }
            int size = stack.size(); // 총합을 구할 때 stack의 사이즈만큼 반복
            for (int i = 0; i < size; i++) {
                sum += stack.pop();
            }
            System.out.printf("#%d %d\n", test_case, sum);
        }
    }
}  