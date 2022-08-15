import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int d = sc.nextInt();
        LocalDate date = LocalDate.ofYearDay(y, d);
        if (date.getDayOfMonth() == 1) {
            System.out.println("true");
        } else System.out.println("false");
    }
}