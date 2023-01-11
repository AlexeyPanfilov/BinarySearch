import java.lang.management.ManagementFactory;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Число от 1 до 10 000 000 000");
        Scanner scanner = new Scanner(System.in);
        long input = scanner.nextLong();
        long max = 100_000_000_000L;
        long min = 1;
        long half = 0;

        Instant start = Instant.now();

        for (long i = 1; i <= max; i++) {
            if (i == input) {
                System.out.println("Число равно " + i);
                break;
            }
        }

        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toNanos();

        Instant startBinary = Instant.now();

        while (half != input) {
            half = (long)Math.floor((max + min) / 2);
            if (half < input) {
                min = half;
            } else {
                max = half;
            }
            Thread.sleep(0);
        }
        Instant finishBinary = Instant.now();
        long elapsedBinary = Duration.between(startBinary, finishBinary).toNanos();

        System.out.println("Время выполнения по порядку: " + elapsed);
        System.out.println("Число (bin) равно: " + half);
        System.out.println();

        System.out.println("Время выполнения бинарного поиска " + elapsedBinary);
    }
}