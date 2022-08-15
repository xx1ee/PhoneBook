import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long sec = sc.nextLong();
        System.out.println(LocalTime.ofSecondOfDay(sec));
    }
}