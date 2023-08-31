import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[] nums; // 양의 정수 배열
    public static int[] tmp; // 병합 정렬을 위한 임시 배열
    public static int K;
    public static int cntK;
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nums = new int[N];
        tmp = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(0, nums.length - 1);
        if (cnt < K) System.out.println(-1); // 저장 횟수가 K보다 작으면 -1 출력
        else System.out.println(cntK);
    }
    // 병합정렬 메소드 (분할)
    public static void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }
    // 병합정렬 메소드 (병합)
    public static void merge(int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;
        while (l <= mid && r <= right) { // 오름차순 정렬
            if (nums[l] <= nums[r]) tmp[idx++] = nums[l++];
            else tmp[idx++] = nums[r++];
        }
        while (l <= mid) {
            tmp[idx++] = nums[l++]; // 나머지 값 처리
        }
        while (r <= right) {
            tmp[idx++] = nums[r++]; // 나머지 값 처리
        }
        for (int i = left; i <= right; i++) {
            nums[i] = tmp[i];
            cnt++;
            if (cnt == K) cntK = nums[i]; // K번째 저장되는 수 대입
        }
    }
}