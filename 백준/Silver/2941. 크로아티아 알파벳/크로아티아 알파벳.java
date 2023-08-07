import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        String s = sc.next();
        
        // 입력받은 문자열을 한 글자씩 리스트에 추가
        for (int i = 0; i < s.length(); i++) {
            list.add((char) s.charAt(i) + "");
        }
        // "dz=" 처리하기
        for (int i = 0; i < list.size() - 2; i++) {
            if (list.get(i).contains("d") && list.get(i + 1).contains("z") && list.get(i + 2).contains("=")) {
                // "dz="를 찾았을 때, 해당 위치와 다음 두 개의 문자를 리스트에서 제거
                list.remove(i + 1);
                list.remove(i + 1);
            }
        }
        // "=" 처리하기
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i).contains("="))
                // "=" 문자가 있으면 해당 문자를 리스트에서 제거
                list.remove(i);
        }
        // "-" 처리하기
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i).contains("-"))
                // "-" 문자가 있으면 해당 문자를 리스트에서 제거
                list.remove(i);
        }
        // "lj"와 "nj" 처리하기
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i).contains("j") && list.get(i - 1).equals("l"))
                // "lj"를 찾았을 때, "j" 문자를 리스트에서 제거
                list.remove(i);
            else if (list.get(i).contains("j") && list.get(i - 1).equals("n"))
                // "nj"를 찾았을 때, "j" 문자를 리스트에서 제거
                list.remove(i);
        }
        // 최종적으로 남은 리스트의 크기를 출력하면 알파벳 개수가 나옴
        System.out.println(list.size());
        sc.close();
    }
}