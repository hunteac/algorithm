import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 길이
        int[] A = new int[N]; // A배열
        int[] B = new int[N]; // B배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) B[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A); // A배열 오름차순 정렬
        Arrays.sort(B); // B배열 오름차순 정렬

        int S = 0;

        for (int i = 0; i < N; i++) S += A[i] * B[N - 1 - i];

        System.out.println(S);
    }
}