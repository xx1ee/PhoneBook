import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] mass = sc.nextLine().split(" ");
        LocalTime time = LocalTime.parse(str);
        System.out.println(time.minusHours(Long.parseLong(mass[0])).minusMinutes(Long.parseLong(mass[1])));
    }
}