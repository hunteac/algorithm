import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int month = 8 + (N - 1) * 7;
        int year = 2024 + month / 12;

        month = month % 12 != 0 ? month % 12 : 12;
        year = month % 12 == 0 ? year - 1 : year;

        System.out.println(year + " " + month);
    }
}