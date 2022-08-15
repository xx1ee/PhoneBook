import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] mas = sc.nextLine().split(" ");
        LocalDateTime date1 = LocalDateTime.parse(mas[0]);
        date1 = date1.plusDays(Integer.parseInt(mas[1])).minusHours(Integer.parseInt(mas[2]));
        System.out.println(date1);
    }
}