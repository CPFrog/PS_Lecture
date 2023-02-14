package part1.week03.C_Thursday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumofSubset {
    static int n;

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        int arr[]=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++)
            arr[i]=Integer.parseInt(st.nextToken());
        int cnt=0;
        for(int i=0;i<(1<<n);i++){
            if(getSums(i,arr)==0)
                cnt++;
        }
        System.out.println(cnt);
    }

    private static int getSums(int flags, int[] arr) {
        int sum=0;
        for(int i=0;i<n;i++){
            if((flags&(1<<i))!=0)
                sum+=arr[i];
        }
        return sum;
    }
}
