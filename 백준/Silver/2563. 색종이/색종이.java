import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] map = new int[100][100]; // 100x100 크기의 이차원 배열 선언
        int n = sc.nextInt(); // 도화지에 그릴 사각형 개수 입력 받기
        int sum = 0; // 도화지에 그린 사각형의 총 넓이를 저장하는 변수

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt(); // 사각형의 왼쪽 위 x 좌표 입력 받기
            int b = sc.nextInt(); // 사각형의 왼쪽 위 y 좌표 입력 받기

            // 사각형의 왼쪽 위 꼭지점을 시작으로 10x10 크기의 사각형 영역을 도화지에 그리기
            for (int j = a; j < a + 10; j++) {
                for (int k = b; k < b + 10; k++) {
                    // 이미 그려진 영역이 아니라면 해당 위치에 사각형 그리기
                    if (map[j][k] == 0) {
                        map[j][k] = 1;
                        sum += 1; // 사각형의 넓이 1 증가
                    }
                }
            }
        }

        System.out.println(sum); // 도화지에 그린 사각형의 총 넓이 출력
        sc.close(); // Scanner 객체 닫기
    }
}