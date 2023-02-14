package part1.week03.A_Tuesday.live;

import java.util.Scanner;

public class Subset_BinaryCountingTest {
    static int[] numbers;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        numbers = new int[n];

        for (int i = 0; i < n; i++)
            numbers[i] = sc.nextInt();

        generateSubset();
    }

    private static void generateSubset() {
        for (int flag = 0, caseCnt = 1 << n; flag < caseCnt; flag++) {
            for (int i = 0; i < n; i++)
                if ((flag & (1 << i)) != 0)
                    System.out.print(numbers[i]+" ");
            System.out.println();
        }
    }
}
