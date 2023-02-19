package Acwing._2二分与前缀和;

import java.io.*;

public class _730机器人问题 {
    static int N = (int)1e5+10;
    static int n;
    static int h[] = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        String s[] =br.readLine().split(" ");
        for (int i = 1; i <= n; i++)
            h[i] =Integer.parseInt(s[i-1]);

        //二分
        int l = 0, r = N;
        while (l < r) {
            int mid = l + r >> 1;
            if (check(mid)) r = mid;
            else l = mid + 1;
        }
        System.out.println(l);
    }

    //校验 传入能量为mid是否符合
    private static boolean check(int e) {
        //遍历每个建筑 是否符合 任意时刻 e>0 、 2*e-h > 0
        for (int i = 1; i <= n; i++) {
            e = 2 * e - h[i];
            if (e >= N) return true;
            if (e < 0) return false;
        }
        return true;
    }
}
