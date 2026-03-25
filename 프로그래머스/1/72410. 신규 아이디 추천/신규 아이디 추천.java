import java.util.*;

class Solution {
    public String first(String id) {
        return id.toLowerCase();
    }
    
    public String second(String id) {
        for (int i = 0; i < id.length(); i++) {
            char c = id.charAt(i);
            
            if ((c >= 'a' && c <= 'z')
                || (c >= 48 && c <= 57)
                || c == '-'
                || c == '_'
                || c == '.') {
                continue;
            }
            
            id = id.substring(0, i) + id.substring(i + 1);
            
            i--;
        }
        
        return id;
    }
    
    public String third(String id) {
        while (id.contains("..")) {
            id = id.replace("..", ".");
        }
        
        return id;
    }
    
    public String fourth(String id) {
        while (id.startsWith(".")) {
            id = id.substring(1);
        }
        while (id.endsWith(".")) {
            id = id.substring(0, id.length() - 1);
        }
        return id;
    }
    
    public String fifth(String id) {
        if ("".equals(id)) {
            id = "a";
        }
        return id;
    }
    
    public String sixth(String id) {
        if (id.length() > 15) {
            id = id.substring(0, 15);
        }
        return id;
    }
    
    public String seventh(String id) {
        while (id.length() < 3) {
            id += id.charAt(id.length() - 1);
        }
        return id;
    }
    
    public String solution(String new_id) {
        // 1단계
        new_id = first(new_id);
        // 2단계
        new_id = second(new_id);
        // 3단계
        new_id = third(new_id);
        // 4단계
        new_id = fourth(new_id);
        // 5단계
        new_id = fifth(new_id);
        // 6단계
        new_id = sixth(new_id);
        // 4단계 추가
        new_id = fourth(new_id);
        // 7단계
        new_id = seventh(new_id);
        
        return new_id;
    }
}