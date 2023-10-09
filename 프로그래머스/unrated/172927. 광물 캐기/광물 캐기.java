import java.util.*;

class Solution {
    static String[][] mineral; // 광물 이차원 배열
    static boolean[] visited; // 방문 체크
    static int[] tmp; // 보유 곡괭이
    static int[] p; // 순열
    static int fatigue; // 피로도
    static int min; // 최소 피로도
    static int num; // 순열 개수

    // 순열 알고리즘을 활용한 광물 고르기
    static void Pick(int[] picks, int idx) {
        // 순열 완성
        if (idx == mineral.length) {
            for (int i = 0; i < 3; i++) tmp[i] = picks[i];
            int sum = picks[0] + picks[1] + picks[2];
            fatigue = 0;
            Mine(sum);
            return;
        }

        for (int i = 0; i < mineral.length; i++) {
            if (visited[i]) continue;
            visited[i] = true; // 원소 선택
            p[idx] = i;
            Pick(picks, idx + 1);
            visited[i] = false; // 원소 선택 X
        }
    }

    // 광석 캐기 + 피로도 구하기
    static void Mine(int sum) {
        int idx = 0;
        for (int i = 0; i < num; i++) {
            int pick = p[i]; // 광물 고르기
            if (sum < num && i != num - 1 && pick == num - 1) return; // 곡괭이 수가 num보다 작을 때 발생하는 예외 상황 처리
            for (int j = 0; j < 5; j++) {
                if (mineral[pick][j] == null) break; // 범위를 벗어나면 break
                if (tmp[0] != 0) { // 다이아 곡괭이 사용
                    fatigue++;
                    idx = 0;
                } else if (tmp[1] != 0) { // 철 곡괭이 사용
                    if (mineral[pick][j].equals("diamond")) fatigue += 5;
                    else fatigue++;
                    idx = 1;
                } else if (tmp[2] != 0) { // 돌 곡괭이 사용
                    if (mineral[pick][j].equals("diamond")) fatigue += 25;
                    else if (mineral[pick][j].equals("iron")) fatigue += 5;
                    else fatigue++;
                    idx = 2;
                }
            }
            tmp[idx]--; // 사용한 곡괭이 제거
        }
        min = Math.min(min, fatigue); // 최소 피로도 구하기
    }

    public int solution(int[] picks, String[] minerals) {
        if (minerals.length % 5 == 0) num = minerals.length / 5;
        else num = minerals.length / 5 + 1;
        
        min = Integer.MAX_VALUE;
        
        mineral = new String[num][5];
        visited = new boolean[num];
        p = new int[num];
        tmp = new int[3];
        
        int idx = 0;
        
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 5; j++) {
                if (idx >= minerals.length) break;
                mineral[i][j] = minerals[idx++];
            }
        }

        Pick(picks, 0);
        
        return min;
        
    }
}