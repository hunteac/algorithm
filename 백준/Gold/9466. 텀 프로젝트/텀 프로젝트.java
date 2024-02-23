import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, answer;
    static int[] nums;
    static boolean[] visited, checked;
    static Queue<Integer> q;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            answer = 0;
            nums = new int[N + 1];
            visited = new boolean[N + 1];
            checked = new boolean[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int i = 1; i <= N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
                if (nums[i] == i) {
                    checked[i] = true;
                    answer++;
                }
            }

            for(int i = 1; i <= N; i++) {
                if (checked[i]) continue;
                dfs(i);
            }

            System.out.println(N-answer);
        }
    }

    static void dfs (int nidx) {
        if (visited[nidx]) {
            checked[nidx] = true;
            answer++;
        } else {
            visited[nidx] = true;
        }

        if (!checked[nums[nidx]]) {
            dfs(nums[nidx]);
        }

        visited[nidx] = false;
        checked[nidx] = true;
    }
}