import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDateTime date1 = LocalDateTime.parse(sc.nextLine());
        date1 = date1.plusHours(11);
        System.out.println(date1.toLocalDate());
        Instant instant = Instant.ofEpochSecond(0l, 1_000_000_001);
        System.out.println(instant);
    }
}