import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] score = new int[N];
		
		for (int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(score); // 오름차순 정렬
		
		int num = (int) Math.round(N * 0.15);
		
		double grade = 0; // 난이도
		int start = num; // 시작
		int end = N - num - 1; // 끝
		
		for (int i = start; i <= end; i++) {
			grade += score[i]; // 위, 아래 제외하고 더하기
		}
		
		System.out.println(Math.round(grade / (end - start + 1))); // 절사평균
	}
}