package Acwing._9DP;

import java.io.*;
import java.util.Arrays;

public class _895最长上升子序列 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int dp[]=new int[n];
        for (int i=0;i<n;i++){
            dp[i]=1;
            for (int j=0;j<i;j++){
                if (arr[j]<arr[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        System.out.println(dp[n-1]);
    }
}



        