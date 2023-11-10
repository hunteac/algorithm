import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int idx;
        int len;
        Node (int to, int len) {
            this.idx = to;
            this.len = len;
        }
        
        @Override
		public int compareTo(Node o) {
			if (this.len > o.len) return 1;
			else return -1;
		}
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 지역 수
        int m = Integer.parseInt(st.nextToken()); // 수색 범위
        int r = Integer.parseInt(st.nextToken()); // 길의 개수

        st = new StringTokenizer(br.readLine());

        List<Node>[] edges = new ArrayList[n + 1]; // 연결 리스트
        int[] item = new int[n + 1]; // 구역별 아이템 개수

        for (int i = 1; i <= n; i++) item[i] = Integer.parseInt(st.nextToken()); // 아이템 개수 담기

        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken()); // 현재 지역
            int to = Integer.parseInt(st.nextToken()); // 연결 지역
            int len = Integer.parseInt(st.nextToken()); // 수색 길이

            edges[from].add(new Node(to, len));
            edges[to].add(new Node(from, len));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        int max = 0; // 아이템 최대 개수

        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1]; // 방문 체크
            queue.add(new Node(i, 0)); // 출발 지역
            int tmp = 0;

            while (!queue.isEmpty()) {
                Node curr = queue.poll(); // 현재 지역
                
                if (visited[curr.idx]) continue; // 이미 방문한 지역이면 continue
                visited[curr.idx] = true; // 방문 체크

                tmp += item[curr.idx]; // 현재 지역 아이템 개수 더하기
                
                for (int j = 0; j < edges[curr.idx].size(); j++) {
                    Node next = edges[curr.idx].get(j); // 다음 지역

                    if (curr.len + next.len > m) continue; // 수색 범위를 벗어나면 continue

                    queue.add(new Node(next.idx, curr.len + next.len)); // 다음 지역과 수색 거리 담기
                }
            }

            max = Math.max(max, tmp); // 최댓값 갱신
        }

        System.out.println(max); // 아이템 최대 개수 출력
    }
}