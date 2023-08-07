import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int sum = 0; 
        int cnt = 0; 
        int left = 0; // 현재 위치에서 왼쪽 빌딩과의 높이 차이를 저장하는 변수
        int right = 0; // 현재 위치에서 오른쪽 빌딩과의 높이 차이를 저장하는 변수
        
        for (int test_case = 1; test_case <= 10; test_case++) {
            int len = sc.nextInt();
            int[] bd = new int[len]; 
            for (int i = 0; i < len; i++) {
                bd[i] = sc.nextInt();
            }
            sum = 0; 
            // 맨 앞 두칸과 맨 뒤 두칸은 빌딩을 세울 수 없다
            for (int i = 2; i < len - 2; i++) {
                cnt = 0; 
                // 왼쪽 두 개 빌딩 높이 중 높은 쪽과의 차이를 계산하여 left에 할당
                if (bd[i - 1] >= bd[i - 2])
                    left = bd[i] - bd[i - 1];
                else
                    left = bd[i] - bd[i - 2];
                // 오른쪽 두 개 빌딩 높이 중 높은 쪽과의 차이를 계산하여 right에 할당
                if (bd[i + 1] >= bd[i + 2])
                    right = bd[i] - bd[i + 1];
                else
                    right = bd[i] - bd[i + 2];
                if (left > 0 && right > 0) {
                    // 두 값 중 더 작은 값만큼 세대 수를 더한다
                    if (left >= right)
                        cnt += right;
                    else
                        cnt += left;
                }
                sum += cnt;
            }
            System.out.printf("#%d %d\n", test_case, sum);
        }
        sc.close();
    }
}