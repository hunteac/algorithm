import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder tmpSb = new StringBuilder();

        int[] score = new int[8];
        int[] tmp = new int[8];

        for (int i = 0; i < 8; i++) {
            score[i] = Integer.parseInt(br.readLine());
            tmp[i] = score[i];
        }

        Arrays.sort(tmp);
        int sum = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 7; j >= 3; j--) {
                if (score[i] == tmp[j]) {
                    sum += tmp[j];
                    tmpSb.append(i + 1 + " ");
                }
            }
        }

        sb.append(sum + "\n");
        sb.append(tmpSb);

        System.out.println(sb); // 출력
    }
}