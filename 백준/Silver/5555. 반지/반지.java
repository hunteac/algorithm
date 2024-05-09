import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String target = br.readLine();

        int N = Integer.parseInt(br.readLine());
        int cnt = 0; // 목표 문자열을 포함하는 반지 개수

        for (int i = 0; i < N; i++) {
            String str = br.readLine(); // 문자열
            str += str; // 원형
            if (str.contains(target)) cnt++; // 목표 문자열 포함 확인
        }

        System.out.println(cnt);
    }
}
