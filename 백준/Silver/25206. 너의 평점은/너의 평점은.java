import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        double sum1 = 0;
        double sum2 = 0;

        for (int i = 0; i < 60; i++) {
            list.add(sc.next());
        }

        for (int i = 1; i < list.size(); i += 3) {
            Double grade = Double.parseDouble(list.get(i));
            String gradeStr = list.get(i + 1);

            switch (gradeStr) {
                case "A+":
                    sum1 += grade * 4.5;
                    sum2 += grade;
                    break;
                case "A0":
                    sum1 += grade * 4.0;
                    sum2 += grade;
                    break;
                case "B+":
                    sum1 += grade * 3.5;
                    sum2 += grade;
                    break;
                case "B0":
                    sum1 += grade * 3.0;
                    sum2 += grade;
                    break;
                case "C+":
                    sum1 += grade * 2.5;
                    sum2 += grade;
                    break;
                case "C0":
                    sum1 += grade * 2.0;
                    sum2 += grade;
                    break;
                case "D+":
                    sum1 += grade * 1.5;
                    sum2 += grade;
                    break;
                case "D0":
                    sum1 += grade * 1.0;
                    sum2 += grade;
                    break;
                case "F":
                    sum2 += grade;
                    break;
                case "P":
                	break;
            }
        }

        System.out.println(sum1 / sum2);
        
        sc.close();
    }
}