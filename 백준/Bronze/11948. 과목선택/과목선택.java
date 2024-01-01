import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] score1 = new int[4];
        int[] score2 = new int[2];

        for (int i = 0; i < 4; i++) {
            score1[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < 2; i++) {
            score2[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(score1);
        Arrays.sort(score2);

        System.out.println(score1[1] + score1[2] + score1[3] + score2[1]);
    }
}