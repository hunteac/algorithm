import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length - 1; i++) { // 두 개 뽑아서 더하기
            for (int j = i + 1; j < numbers.length; j++) {
                if (list.contains(numbers[i] + numbers[j])) continue; // 이미 포함된 수라면 continue
                list.add(numbers[i] + numbers[j]);
            }
        }
        Collections.sort(list); // 오름차순 정렬
        return list.stream().mapToInt(i -> i).toArray(); // 리스트 -> 배열 변환
    }
}