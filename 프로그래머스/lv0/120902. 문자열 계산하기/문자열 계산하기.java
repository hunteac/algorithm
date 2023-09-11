import java.util.Arrays;

class Solution {
    public int solution(String my_string) {
        String[] arr = my_string.split(" ");
        for (int i = 1; i < arr.length - 1; i += 2) {
            int n = Integer.parseInt(arr[i + 1]);
            int m = Integer.parseInt(arr[i - 1]);
            if (arr[i].equals("+")) arr[i + 1] = String.valueOf(m + n); 
            else arr[i + 1] = String.valueOf(m - n); 
        }
        return Integer.parseInt(arr[arr.length - 1]);
    }
}