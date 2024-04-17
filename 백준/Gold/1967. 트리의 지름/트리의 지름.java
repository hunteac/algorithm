import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int child; // 자식
        int len; // 길이

        Node (int child, int len) {
            this.child = child;
            this.len = len;
        }
    }

    static ArrayList<Node>[] tree; // 트리
    static ArrayList<Integer>[] level; // 노드 레벨
    static int[] length; // 리프 노드까지의 최대 길이
    static int N, diameter, max;

    // 노드 레벨 구하기
    static void getLevel(int curr, int lv) {
        level[lv].add(curr);
        max = Math.max(max, lv);

        for (int idx = 0; idx < tree[curr].size(); idx++) {
            int child = tree[curr].get(idx).child;
            getLevel(child, lv + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        level = new ArrayList[N + 1];
        length = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
            level[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken()); // 부모
            int c = Integer.parseInt(st.nextToken()); // 자식
            int len = Integer.parseInt(st.nextToken()); // 길이

            tree[p].add(new Node(c, len));
        }

        getLevel(1, 1);

        for (int i = max - 1; i >= 1; i--) {
            for (int j = 0; j < level[i].size(); j++) {
                int num = level[i].get(j); // 노드 번호
                int first = 0; // 리프 노드까지 최대 길이
                int second = 0; // 리프 노드까지 두번째로 긴 길이

                for (int idx = 0; idx < tree[num].size(); idx++) {
                    int child = tree[num].get(idx).child;
                    int len = length[child] + tree[num].get(idx).len;

                    if (len > first) {
                        second = first;
                        first = len;
                        continue;
                    }
                    second = Math.max(second, len);
                }

                length[num] = first; // 자식 노드 중 최대 길이
                diameter = Math.max(diameter, first + second); // 지름 갱신
            }
        }

        System.out.println(diameter);
    }
}