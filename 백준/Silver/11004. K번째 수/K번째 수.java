import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

        quickSort(nums, 0, N - 1);

        System.out.println(nums[K - 1]);
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left + 1 == right) {
            if (nums[left] > nums[right]) {
                swap(nums, left, right);
                return;
            }
        }

        int currL = left;
        int currR = right;
        int pivot = nums[(left + right) / 2];

        while (currL <= currR) {
            while (nums[currL] < pivot) currL++;
            while (nums[currR] > pivot) currR--;

            if (currL <= currR) {
                swap(nums, currL++, currR--);
            }
        }

        if (left < currR) quickSort(nums, left, currR);
        if (right > currL) quickSort(nums, currL, right);
    }

    public static void swap(int[] nums, int A, int B) {
        int tmp = nums[B];
        nums[B] = nums[A];
        nums[A] = tmp;
    }
}