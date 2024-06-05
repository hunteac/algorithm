import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 책의 개수

        HashMap<String, Integer> booksCount = new HashMap<>(); // 책 별 팔린 개수
        String[] books = new String[N]; // 팔린 책들
        String book = ""; // 가장 많이 팔린 책
        int max = 0; // 최대 개수

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            books[i] = name;
            booksCount.put(name, booksCount.getOrDefault(name, 0) + 1);
            max = Math.max(max, booksCount.get(name));
        }

        Arrays.sort(books); // 사전 순 오름차순 정렬

        for (int i = 0; i < N; i++) {
            if (booksCount.get(books[i]) < max) continue;
            book = books[i];
            break; // 사전 순
        }

        System.out.println(book);
    }
}
