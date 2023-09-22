import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++) {
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken()); // 정점 수
            int E = Integer.parseInt(st.nextToken()); // 간선 수

            List<Integer>[] edges = new ArrayList[V + 1]; // 간선 정보를 담기 위한 리스트 배열 생성

            for (int i = 1; i < V + 1; i++) {
                edges[i] = new ArrayList<>(); // 리스트 생성
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < E; i++) {
                int A = Integer.parseInt(st.nextToken()); // 시작 정점
                int B = Integer.parseInt(st.nextToken()); // 인접 정점

                // 유향 그래프
                edges[A].add(B); // 시작 정점과 인접한 정점들 담기
            }

            Queue<Integer> queue = new LinkedList<>(); // 위상정렬을 위한 큐 생성
            int[] degree = new int[V + 1]; // 진입차수 배열

            for (int i = 1; i < V + 1; i++) {
                for (int j = 0; j < edges[i].size(); j++) {
                    degree[edges[i].get(j)]++; // 각 정점별 진입차수 구하기
                }
            }

            // 진입차수가 0인 정점들만 큐에 넣는다.
            for (int i = 1; i < V + 1; i++) {
                if (degree[i] == 0) {
                    degree[i] = -1;
                    queue.add(i);
                }
            }

            // 큐가 공백일때까지 반복문 수행
            while (!queue.isEmpty()) {
                int v = queue.poll();

                for (int i = 0; i < edges[v].size(); i++) {
                    degree[edges[v].get(i)]--; // v 정점과 인접한 정점들의 진입차수 - 1
                }

                for (int i = 1; i < V + 1; i++) {
                    if (degree[i] == 0) {
                        degree[i] = -1;
                        queue.add(i); // 진입차수가 0이면 큐에 넣기
                    }
                }

                sb.append(v).append(" "); // 작업 순서대로 출력
            }

            System.out.println("#" + tc + " " + sb);
        }
    }
}