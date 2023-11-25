import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int color = Integer.parseInt(br.readLine());

        if (color >= 620 && color <= 780) {
            System.out.println("Red");
        } else if (color >= 590 && color < 620) {
            System.out.println("Orange");
        } else if (color >= 570 && color < 590) {
            System.out.println("Yellow");
        } else if (color >= 495 && color < 570) {
            System.out.println("Green");
        } else if (color >= 450 && color < 495) {
            System.out.println("Blue");
        } else if (color >= 425 && color < 450) {
            System.out.println("Indigo");
        } else if (color >= 380 && color < 425) {
            System.out.println("Violet");
        }
    }
}