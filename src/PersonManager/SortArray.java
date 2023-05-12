package PersonManager;

import java.util.Arrays;
import java.util.Random;

public class SortArray {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        Random random = new Random();

        // Füllen des Arrays mit Zufallszahlen
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
        }

        // Sortieren des Arrays
        Arrays.sort(numbers);

        // Ausgabe der sortierten Zahlen
        System.out.println("Sortierte Zahlen:");
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}

