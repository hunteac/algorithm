class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int[] tmp = new int[30]; // 임시 배열 선언
        int cnt = 0;
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = -1;
        }
        // 슬라이싱
        if (n == 1) {
            for (int i = 0; i <= slicer[1]; i++) {
                tmp[i] = num_list[i];
                cnt++;
            }
        } else if (n == 2) {
            for (int i = slicer[0]; i < num_list.length; i++) {
                tmp[i] = num_list[i];
                cnt++;
            }  
        } else if (n == 3) {
            for (int i = slicer[0]; i <= slicer[1]; i++) {
                tmp[i] = num_list[i];
                cnt++;
            }
        } else {
            for (int i = slicer[0]; i <= slicer[1]; i += slicer[2]) {
                tmp[i] = num_list[i];
                cnt++;
            }
        }
        int[] answer = new int[cnt]; // 정수형 배열 선언
        cnt = 0;
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] != -1) answer[cnt++] = tmp[i]; // 슬라이싱 한 값 담기
        }
        return answer;
    }
}