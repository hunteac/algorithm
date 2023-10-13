import java.util.*;

public class Main {

    static PriorityQueue<Integer> queue; // 쉬운 난이도 문제 순
    static List<Integer>[] adjList; // 인접리스트
    static int[] d; // 선행작업 수
    static int N; // 문제 수
    static int M; // 간선 수


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        adjList = new ArrayList[N + 1];
        d = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            adjList[A].add(B);
            d[B]++;
        }

        queue = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            if (d[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int n = queue.poll();

            for (int i = 0; i < adjList[n].size(); i++) {
                if (--d[adjList[n].get(i)] == 0) queue.add(adjList[n].get(i)); // 선행작업을 모두 끝내면 큐에 넣기
            }

            System.out.print(n + " ");
        }
    }
}