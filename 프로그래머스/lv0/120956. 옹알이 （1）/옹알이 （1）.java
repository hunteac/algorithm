class Solution {
    public int solution(String[] babbling) {
        int answer = 0; // 단어 개수
        boolean chk = false; // 발음 가능 여부
        for (int i = 0; i < babbling.length; i++) {
            int idx = 0;
            while (idx < babbling[i].length()) { // babbling의 각 인덱스를 확인하며 발음 가능 여부 파악
                if (idx + 2 < babbling[i].length() && babbling[i].charAt(idx) == 'a') {
                    if ((String.valueOf(babbling[i].charAt(idx + 1)) + String.valueOf(babbling[i].charAt(idx + 2))).equals("ya")) {
                        idx += 3;
                        chk = true; // 발음 가능
                    } else {
                        chk = false; // 발음 불가능
                        break;
                    } 
                } else if (idx + 1 < babbling[i].length() && babbling[i].charAt(idx) == 'y') {
                    if (babbling[i].charAt(idx + 1) == 'e') {
                        idx += 2;
                        chk = true;
                    } else {
                        chk = false;
                        break;
                    }
                } else if (idx + 2 < babbling[i].length() && babbling[i].charAt(idx) == 'w') {
                    if ((String.valueOf(babbling[i].charAt(idx + 1)) + String.valueOf(babbling[i].charAt(idx + 2))).equals("oo")) {
                        idx += 3;
                        chk = true;
                    } else {
                        chk = false;
                        break;
                    } 
                } else if (idx + 1 < babbling[i].length() && babbling[i].charAt(idx) == 'm') {
                    if (babbling[i].charAt(idx + 1) == 'a') {
                        idx += 2;
                        chk = true;
                    } else {
                        chk = false;
                        break;
                    }
                } else {
                    chk = false;
                    break;
                }
            }
            if (chk) answer++; // 발음할 수 있다면 단어 개수 + 1
        }
        return answer;
    }
}