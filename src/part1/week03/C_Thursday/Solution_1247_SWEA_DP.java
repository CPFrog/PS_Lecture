package part1.week03.C_Thursday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1247_SWEA_DP {
    static int[] minDist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            int posArr[][] = new int[n + 2][2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            posArr[0] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            posArr[n + 1] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            int[] p = new int[n];
            for (int i = 1; i <= n; i++) {
                posArr[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
                p[i - 1] = i;
            }
            int dist[][] = new int[n + 2][n + 2];
            for (int i = 0; i < n + 1; i++) {
                for (int j = i + 1; j < n + 2; j++) {
                    int tmp = getDistance(posArr[i], posArr[j]);
                    dist[i][j] = tmp;
                    dist[j][i] = tmp;
                }
            }

            int minDist = Integer.MAX_VALUE;
            do {
                int sum = dist[0][p[0]];
                for (int i = 0; i < n - 1; i++)
                    sum += dist[p[i]][p[i + 1]];
                sum += dist[p[n - 1]][n + 1];
                if (minDist > sum)
                    minDist = sum;
            } while (np(n - 1, p));
            sb.append("#" + t + " " + minDist + "\n");
        }
        System.out.print(sb.toString());

    }

    static int getDistance(int[] from, int[] to) {
        return Math.abs(from[0] - to[0]) + Math.abs(from[1] - to[1]);
    }

    private static boolean np(int size, int[] arr) {
        int i = size;
        while (i > 0 && arr[i - 1] > arr[i])
            i--;
        if (i == 0)
            return false;
        int j = size;
        while (arr[i - 1] > arr[j])
            j--;
        swap(i - 1, j, arr);
        int k = size;
        while (i < k)
            swap(i++, k--, arr);
        return true;
    }

    private static void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    static class Point {
        int r, c;

        public Point(int name, int distance) {
            this.r = name;
            this.c = distance;
        }
    }
}
