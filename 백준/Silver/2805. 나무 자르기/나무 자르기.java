import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] heights = new int[N];

        st = new StringTokenizer(br.readLine());

        int max = 0;

        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, heights[i]);
        }

        int start = 0;
        int end = max;
        int mid = 0;
        max = 0;

        while (start + 1 < end) {
            mid = (start + end) / 2;

            if (checkHeight(heights, mid, M)) {
                max = Math.max(max, mid);
                start = mid;
            } else {
                end = mid;
            }
        }

        System.out.println(max);
    }

    public static boolean checkHeight(int[] heights, int mid, int target) {
        boolean chk = true;

        long sum = 0;

        for (int height : heights) {
            if (height > mid) sum += height - mid;
        }

        if (sum < target) chk = false;

        return chk;
    }
}