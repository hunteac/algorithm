import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        String answer = "";

        for (int i = 0; i < word.length() - 2; i++) {
            for (int j = i + 1; j < word.length() - 1; j++) {
                for (int k = j + 1; k < word.length(); k++) {
                    String tmp = "";
                    StringBuffer sb = new StringBuffer(word.substring(0, j)); // 첫번째 단어
                    tmp += sb.reverse().toString(); // 단어 뒤집기
                    sb = new StringBuffer(word.substring(j, k)); // 두번째 단어
                    tmp += sb.reverse().toString();
                    sb = new StringBuffer(word.substring(k)); // 세번째 단어
                    tmp += sb.reverse().toString();

                    for (int l = 0; l < tmp.length() - 1; l++) { // 사전순 비교
                        if (answer.isEmpty()) {
                            answer = tmp;
                            break;
                        }

                        if (answer.charAt(l) > tmp.charAt(l)) {
                            answer = tmp;
                            break;
                        } else if (answer.charAt(l) == tmp.charAt(l)) {
                            if (answer.charAt(l + 1) > tmp.charAt(l + 1)) {
                                answer = tmp;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}