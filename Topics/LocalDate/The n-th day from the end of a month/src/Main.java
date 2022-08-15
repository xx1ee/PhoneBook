import javax.swing.*;
import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] date0 = sc.nextLine().split(" ");
        LocalDate date = LocalDate.of(Integer.parseInt(date0[0]), Integer.parseInt(date0[1]), Integer.parseInt(date0[2]));
        //int day = sc.nextInt();
        int days = date.lengthOfMonth();
        date = date.withDayOfMonth(days - Integer.parseInt(date0[2]) + 1);
        System.out.println(date);
    }
}