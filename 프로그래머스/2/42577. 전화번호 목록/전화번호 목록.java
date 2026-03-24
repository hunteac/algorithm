import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        // 1. 해시셋 담기
        HashSet<String> set = new HashSet<>();
        
        // 2. 전화번호 조회
        Outer: for (int i = 0; i < phone_book.length; i++) {
            String phone = phone_book[i];
            String word = "";
            
            // 3. 전화번호 부분 조회
            for (int j = 0; j < phone.length(); j++) {
                // 접두어 번호 존재하는지 확인
                word += phone.charAt(j);
                
                if (set.contains(word)) {
                    answer = false;
                    break Outer;
                }
            }
            
            set.add(phone);
        }
        
        return answer;
    }
}