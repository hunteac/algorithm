class Solution {
    public String solution(String new_id) {
        String tmp = "";
        int cnt = 0; // 마침표 개수
        
        // 1, 2단계
        for (int idx = 0; idx < new_id.length(); idx++) {
            if (new_id.charAt(idx) >= 65 && new_id.charAt(idx) <= 90) { // 1단계
                tmp += Character.toLowerCase(new_id.charAt(idx));
            } else if ((new_id.charAt(idx) >= 97 && new_id.charAt(idx) <= 122) || (new_id.charAt(idx) >= 48 && new_id.charAt(idx) <= 57)) { // 2단계 (소문자, 숫자)
                tmp += new_id.charAt(idx);
            } else if (new_id.charAt(idx) == '-' || new_id.charAt(idx) == '_' || new_id.charAt(idx) == '.') { // 2단계 ('-', '_', '.')
                tmp += new_id.charAt(idx);
            }
        }
        
        new_id = tmp;
        tmp = "";

        // 3단계
        for (int idx = 0; idx < new_id.length(); idx++) {
            if (idx < new_id.length() - 1 && new_id.charAt(idx) == '.' && new_id.charAt(idx + 1) == '.') continue;
            tmp += new_id.charAt(idx);
        }
        
        new_id = tmp;
        tmp = "";
        
        // 4단계
        for (int idx = 0; idx < new_id.length(); idx++) {
            if ((idx == 0 || idx == new_id.length() - 1) && new_id.charAt(idx) == '.') continue;
            tmp += new_id.charAt(idx);
        }        
        
        new_id = tmp;
        
        // 5단계
        if (new_id.equals("")) new_id += "a";
        
        // 6단계
        if (new_id.length() > 15) {
            tmp = "";
            for(int idx = 0; idx < 15; idx++) {
                if (idx == 14 && new_id.charAt(idx) == '.') continue; // 마지막 마침표 제거
                tmp += new_id.charAt(idx);
            }
            new_id = tmp;
        }
        
        // 7단계
        if (new_id.length() < 3) {
            while (new_id.length() < 3) {
                new_id += new_id.charAt(new_id.length() - 1);
            }
        }
        
        return new_id;
    }
}