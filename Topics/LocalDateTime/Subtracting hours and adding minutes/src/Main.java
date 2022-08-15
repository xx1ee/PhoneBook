import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDateTime date1 = LocalDateTime.parse(sc.nextLine());
        String[] mas = sc.nextLine().split(" ");
        date1 = date1.minusHours(Integer.parseInt(mas[0])).plusMinutes(Integer.parseInt(mas[1]));
        System.out.println(date1);
    }
}