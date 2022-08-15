import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int m = sc.nextInt();
        LocalDate date = LocalDate.of(y, m, 1);
        int last = date.lengthOfMonth();
        System.out.print(date + " ");
        date = date.withDayOfMonth(last);
        System.out.println(date);
    }
}