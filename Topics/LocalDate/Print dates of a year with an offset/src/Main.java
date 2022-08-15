import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        long day = sc.nextLong();
        LocalDate date = LocalDate.parse(str);
        int year = date.getYear();
        //System.out.println(date);
        while (date.getYear() == year) {
            System.out.println(date);
            date = date.plusDays(day);
        }
    }
}