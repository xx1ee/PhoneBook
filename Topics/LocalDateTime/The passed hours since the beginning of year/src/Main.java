import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDateTime date1 = LocalDateTime.parse(sc.nextLine());
        LocalDateTime date0 = LocalDateTime.of(date1.getYear(), 1, 1, 0, 0);
        System.out.println(Duration.between(date0, date1).toHours());
    }
}