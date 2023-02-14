package part1.week03.C_Thursday;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NQueens_1DArray {
    static int n, cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int cols[] = new int[n];

        NQueen(0, cols);
        System.out.println(cnt);
    }

    private static void NQueen(int depth, int[] cols) {
        if(depth==n) {
            cnt++;
            return;
        }
        for(int i=0;i<n;i++){
            if(isAvaliable(depth, i, cols)){
                cols[depth]=i;
                NQueen(depth+1,cols);
            }
        }
    }

    private static boolean isAvaliable(int depth, int target, int[] cols) {
        for(int i=0;i<depth;i++)
            if(depth==i || Math.abs(depth-i) == Math.abs(target-cols[i]))
                return false;
        return true;
    }
}
