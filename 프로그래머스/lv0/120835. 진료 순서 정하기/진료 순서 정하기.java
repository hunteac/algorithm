import java.util.Arrays;

class Solution {
    public int[] solution(int[] emergency) {
        int[] tmp = new int[emergency.length]; // 임시 배열
        int[] answer = new int[emergency.length];
        for (int i = 0; i < emergency.length; i++) {
            tmp[i] = emergency[i];
        }
        Arrays.sort(emergency); // 오름차순 정렬
        int order = 1; // 진료 순서
        for (int i = emergency.length - 1; i >= 0; i--) {
            for (int j = 0; j < tmp.length; j++) {
                if (emergency[i] == tmp[j]) {
                    answer[j] = order++; // 응급도가 높은 순으로 진료 순서 부여
                    break;
                }
            }
        }
        return answer;
    }
}