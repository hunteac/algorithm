class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "fail";
        for (int i = 0; i < db.length; i++) {
            if (!id_pw[0].equals(db[i][0])) continue; // 아이디가 동일하지 않으면 continue
            answer = "wrong pw"; // 아이디만 동일하면 "wrong pw"
            if (id_pw[1].equals(db[i][1])) answer = "login"; // 모두 동일하면 "login"
        }
        return answer;
    }
}