import java.util.Scanner;

class Main {
    public static void printPartitions(String suffix, int max, int target) {
        if (target == 0)
            System.out.println(suffix);
        else
        {
            for (int i = 1; i <= target && i <= max; i++)
                printPartitions(suffix + " " + i, i, target - i);
        }
    }
    public static void begin(int tg) {
        printPartitions("", tg, tg);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch = sc.nextInt();
        begin(ch);
    }
}