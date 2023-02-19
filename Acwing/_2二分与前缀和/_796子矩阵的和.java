package Acwing._2二分与前缀和;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _796子矩阵的和 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[0]);
        int q = Integer.parseInt(s1[0]);
        int a[][] = new int[1010][1010];
        int s[][] = new int[1010][1010];//保存二维前缀和
        for (int i = 1; i <= n; i++) {
            String[] s2 = br.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                a[i][j] = Integer.parseInt(s2[j - 1]);
                //容斥原理
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + a[i][j];
            }
        }

        //查询q次
        while (q-- > 0) {
            String[] s3 = br.readLine().split(" ");
            int x1 = Integer.parseInt(s3[0]);
            int y1 = Integer.parseInt(s3[1]);
            int x2 = Integer.parseInt(s3[2]);
            int y2 = Integer.parseInt(s3[3]);
            //容斥原理
            int res = s[x2][y2] - s[x1 - 1][y2] - s[x2][y1 - 1] + s[x1 - 1][y1 - 1];
            System.out.println(res);
            s3=null;
        }
    }
}
