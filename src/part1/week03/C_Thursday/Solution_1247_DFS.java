package part1.week03.C_Thursday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1247_DFS {
    static Point office, home, pArr[];
    static int n, dist[][], curMin;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            curMin = Integer.MAX_VALUE;
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            office = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            pArr = new Point[n];
            dist = new int[n][n];
            for (int i = 0; i < n; i++) {
                pArr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                for(int j=0;j<i;j++)
                    dist[i][j] = dist[j][i]=getDistance(pArr[i], pArr[j]);
            }
            dfs(0,0,-1,0);
            sb.append("#" + t + " " + curMin + "\n");
        }
        System.out.print(sb.toString());
    }

    static int getDistance(Point from, Point to) {
        return Math.abs(from.r - to.r) + Math.abs(from.c - to.c);
    }

    private static void dfs(int depth, int flag, int lastPos, int sum) {
        if (depth == n) {
            int tmp = sum + getDistance(pArr[lastPos], home);
            if (curMin > tmp) curMin = tmp;
            return;
        }
        if (depth == 0) {
            for (int i = 0; i < n; i++) {
                int startDist = getDistance(office, pArr[i]);
                if (startDist < curMin)
                    dfs(depth + 1, flag | (1 << i), i, startDist);
            }
        } else {
            for (int i = 0; i < n; i++) {
                if ((flag & (1 << i)) == 0) {
                    int tmpSum = sum + dist[lastPos][i];
                    if (curMin > tmpSum)
                        dfs(depth + 1, flag | (1 << i), i, tmpSum);
                }
            }
        }
    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
