package Acwing._3数学与简单DP;

import java.io.*;

public class _895最长上升子序列 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String s[] = br.readLine().split(" ");
        int a[] = new int[N + 1];
        for (int i = 1; i <= N; i++)
            a[i] = Integer.parseInt(s[i - 1]);

        int dp[] = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        System.out.println(dp[N]);
    }
}
