import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 과일의 개수
        st = new StringTokenizer(br.readLine());

        if (N == 1) { // 과일이 1개인 경우
            System.out.println(1);
            return;
        }

        int[] fruits = new int[N];

        for (int i = 0; i < N; i++) fruits[i] = Integer.parseInt(st.nextToken());

        HashSet<Integer> selectedFruit = new HashSet<>(); // 연속된 과일 2종류
        int sum = 0; // 2종류 합
        int max = 0; // 2종류 합 최대 개수
        int beforeCnt = 0; // 이전 과일 개수
        int beforeFruit = 0; // 이전 과일 종류

        for (int i = 0; i < N; i++) {
            int num = fruits[i];
            if (selectedFruit.size() < 2 || selectedFruit.contains(num)) { // 2종류 미만이거나 연속된 2종류
                if (beforeFruit == num) beforeCnt++;
                else beforeCnt = 1;
                selectedFruit.add(num);
                sum++;
            } else { // 새로운 과일
                selectedFruit.clear();
                selectedFruit.add(beforeFruit);
                selectedFruit.add(num);
                sum = beforeCnt + 1;
                beforeCnt = 1;
            }

            beforeFruit = num;
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
