class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] paint = new boolean[n + 1];
        for (int i = 0; i < section.length; i++) {
            paint[section[i]] = true; // true = 칠해야 하는 벽, false = 칠할 필요 없는 벽
        }
        for (int i = 0; i < section.length; i++) {
            if (!paint[section[i]]) continue; // 이미 칠해진 벽은 continue
            if (section[i] + m < paint.length) {
                for (int j = section[i]; j < section[i] + m; j++) {
                    paint[j] = false; // 페인트 칠하기
                }
            } else {
                for (int j = section[i]; j < paint.length; j++) {
                    paint[j] = false; // 페인트 칠하기
                }
            }
            answer++; // 페인트 칠 횟수 + 1
        }
        return answer;
    }
}