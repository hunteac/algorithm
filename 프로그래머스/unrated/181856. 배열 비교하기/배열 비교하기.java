class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        if (arr1.length > arr2.length) return 1; // 두 배열의 길이 비교
        else if (arr2.length > arr1.length) return -1;
        for (int i = 0; i < arr1.length - 1; i++) { // 길이가 같다면 모든 원소들의 합 비교
            arr1[i + 1] += arr1[i];
            arr2[i + 1] += arr2[i];
        } 
        if (arr1[arr1.length - 1] > arr2[arr2.length - 1]) return 1;
        else if (arr2[arr2.length - 1] > arr1[arr1.length - 1]) return -1;
        return answer; // 모두 같다면 0 반환
    }
}