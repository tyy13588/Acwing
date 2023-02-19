package Acwing._4枚举_模拟_排序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class _1204错误票据 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N = 10010;
    static int a[] = new int[N];//保存读入的数据
    static int k = 0;

    public static void main(String[] args) throws IOException {
        int lines = Integer.parseInt(br.readLine());
        while (lines-- > 0) {//循环读入
            String[] s = br.readLine().split("\\s+"); // "\s"匹配任何空白字符，包括空格、制表符、换页符等等, 等价于[ \f\n\r\t\v]
            for (int i = 0; i < s.length; i++) {
                a[k++] = Integer.parseInt(s[i]);
            }
        }

        Arrays.sort(a);
        //遍历找出 断号n 重号m
        int n=0, m=0;
        for (int i = 1; i < N; i++) {
            if (a[i] == a[i - 1]) m = a[i];
            else if (a[i] >= a[i - 1] + 2) n = a[i] - 1;
        }
        System.out.println(n+" "+m);
    }
}
