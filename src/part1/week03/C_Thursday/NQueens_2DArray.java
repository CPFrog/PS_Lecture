package part1.week03.C_Thursday;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NQueens_2DArray {
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[][] board = new boolean[n][n];
        NQueens(0, n, board);
        System.out.println(cnt);
    }

    static void NQueens(int depth, int n, boolean[][] board) {
        if (depth == n) {
            cnt++;
            StringBuilder sb = new StringBuilder();
            for (boolean[] b : board) {
                for (boolean i : b)
                    sb.append((i ? 1 : 0 )+ " ");
                sb.append("\n");
            }
            System.out.println(sb.toString());
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean isValid = true;
            for (int j = 0; j < depth && isValid; j++) {
                for (int k = 0; k < n && isValid; k++) {
                    if (board[j][k]) {
                        if (Math.abs(depth - j) == Math.abs(i - k) || k==i)
                            isValid = false;
                        break;
                    }
                }
            }
            if (isValid) {
                board[depth][i] = true;
                NQueens(depth + 1, n, board);
                board[depth][i] = false;
            }
        }
    }
}
