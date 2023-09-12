class Solution {
    public int solution(String[] spell, String[] dic) {
        boolean[] chk = new boolean[spell.length];
        int answer = 2;
        int cnt = 0;
        for (int i = 0; i < dic.length; i++) {
            cnt = 0;
            for (int j = 0; j < chk.length; j++) {
                chk[j] = false;
            }
            for (int j = 0; j < spell.length; j++) {
                for (int k = 0; k < dic[i].length(); k++) {
                    if (spell[j].equals(String.valueOf(dic[i].charAt(k)))) chk[j] = true;
                }
            }
            for (int j = 0; j < chk.length; j++) { // spell에 담긴 알파벳을 모두 한 번씩 사용했는지 확인
                if (chk[j]) cnt++;
            }
            if (cnt == spell.length) { // 모두 한 번씩 사용했다면 answer = 1
                answer = 1;
                break;
            }
        }
        return answer;
    }
}