package DIY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_Q1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            int n=Integer.parseInt(br.readLine());
            int[] arr=new int[n];
            int door[][]=new int[3][2];
            for(int i=0;i<3;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 2; j++)
                    door[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
