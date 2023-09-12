class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int min = 101;
        int first = 0; // 1등 순서
        int second = 0; // 2등 순서
        int third = 0; // 3등 순서
        for (int i = 0; i < rank.length; i++) { // 1등 순서 구하기
            if (!attendance[i]) continue;
            if (rank[i] < min) {
                min = rank[i];
                first = i;
            }
        }
        min = 101;
        for (int i = 0; i < rank.length; i++) { // 2등 순서 구하기
            if (!attendance[i]) continue;
            if (rank[i] < min) {
                if (rank[i] > rank[first]) {
                    min = rank[i];
                    second = i;
                }
            }
        }
        min = 101;
        for (int i = 0; i < rank.length; i++) { // 3등 순서 구하기
            if (!attendance[i]) continue;
            if (rank[i] < min) {
                if (rank[i] > rank[first]) {
                    if (rank[i] > rank[second]) {
                        min = rank[i];
                        third = i;    
                    }
                }
            }
        }
        return (10000 * first) + (100 * second) + third;
    }
}