class Solution {
    public int solution(String[] spell, String[] dic) {
        boolean[] chk = new boolean[spell.length];
        int answer = 2;
        int cnt = 0;
        Outer: for (int i = 0; i < dic.length; i++) {
            cnt = 0;
            chk = new boolean[spell.length];
            for (int j = 0; j < spell.length; j++) {
                for (int k = 0; k < dic[i].length(); k++) {
                    if (spell[j].equals(String.valueOf(dic[i].charAt(k)))) chk[j] = true; // 해당 알파벳을 사용하면 true
                }
            }
            for (int j = 0; j < chk.length; j++) { // spell에 담긴 알파벳을 모두 한 번씩 사용했는지 확인
                if (!chk[j]) continue Outer; // false가 존재하면 continue
            }
            answer = 1; // 모두 한 번씩 사용했다면 answer = 1
            break;
        }
        return answer;
    }
}