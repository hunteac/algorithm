import java.util.Scanner;

public class Solution {
    public static int[] A;
    public static int[] tmpA;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        A = new int[1000000];
        tmpA = new int[1000000];

        for (int i = 0; i < A.length; i++) {
            A[i] = sc.nextInt();
        }

        mergeSort(0, A.length - 1);
        System.out.println(A[500000]);
    }
    // 병합 정렬 메소드 (분할)
    public static void mergeSort(int left, int right) {
        // 재귀파트
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid); // 왼쪽 탐색
            mergeSort(mid + 1, right); // 오른쪽 탐색
            merge(left, mid, right); // 병합
        }
    }
    // 병합 정렬 메소드 (병합)
    public static void merge(int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;

        while (l <= mid && r <= right) {
            if (A[l] <= A[r]) { // 분할된 오른쪽 배열과 왼쪽 배열 값 비교
                tmpA[idx++] = A[l++];
            } else {
                tmpA[idx++] = A[r++];
            }
        }
        while (l <= mid) {
            tmpA[idx++] = A[l++]; // 남은 값 넣기
        }
        while (r <= right) {
            tmpA[idx++] = A[r++]; // 남은 값 넣기
        }
        for (int i = left; i <= right; i++) {
            A[i] = tmpA[i]; // 기존 배열에 정렬된 값 넣기
        }
    }
}