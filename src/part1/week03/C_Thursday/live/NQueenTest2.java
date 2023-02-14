package part1.week03.C_Thursday.live;

import java.util.Scanner;

public class NQueenTest2 {
    static int n, cols[], ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        cols = new int[n + 1];
        ans = 0;
        setQueen(1);
        System.out.println(ans);
        sc.close();
    }

    static void setQueen(int rowNo) {
        if (!isAvaliable(rowNo - 1)) return;
        if (rowNo > n) {
            ans++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            cols[rowNo] = i;
            if (isAvaliable(rowNo))
                setQueen(rowNo + 1);
        }
    }

    private static boolean isAvaliable(int rowNo) {
        for (int j = 1; j < rowNo; j++)
            if (cols[j] == cols[rowNo] || Math.abs(rowNo - j) == Math.abs(cols[rowNo] - cols[j]))
                return false;
        return true;
    }
}
