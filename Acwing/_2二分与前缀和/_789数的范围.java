package Acwing._2二分与前缀和;

import java.io.IOException;
import java.util.Scanner;

public class _789数的范围 {
    static int[] arr = new int[100010];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        //获取输入
        int n = sc.nextInt();
        int q = sc.nextInt();
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        //依次查询 q个数字
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            //二分x的左端点
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (arr[mid] >= x) r = mid;
                else l = mid + 1;
            }
            //判断得到的第一个数字 是否等于 查询的 x
            if (arr[r] == x) {
                System.out.print(r+" ");
                r = n - 1;
                while (l < r) {
                    int mid = l + r +1>> 1;// +1
                    if (arr[mid] <= x) l = mid;
                    else r = mid - 1;
                }
                System.out.print(l);
            } else
                System.out.println("-1 -1");
        }
    }
}
