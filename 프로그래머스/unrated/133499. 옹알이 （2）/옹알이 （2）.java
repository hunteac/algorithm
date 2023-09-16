class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        Outer: for (int i = 0; i < babbling.length; i++) {
            babbling[i] = babbling[i].replace("aya", "1");
            babbling[i] = babbling[i].replace("ye", "2");
            babbling[i] = babbling[i].replace("woo", "3");
            babbling[i] = babbling[i].replace("ma", "4");
            
            for (int j = 0; j < babbling[i].length() - 1; j++) { // 같은 발음을 연속으로 발음할 수 없다.
                if (babbling[i].charAt(j) == babbling[i].charAt(j + 1)) continue Outer;
            }
            
            babbling[i] = babbling[i].replace("1", "");
            babbling[i] = babbling[i].replace("2", "");
            babbling[i] = babbling[i].replace("3", "");
            babbling[i] = babbling[i].replace("4", "");
            
            if (babbling[i].equals("")) answer++;
        }
        return answer;
    }
}