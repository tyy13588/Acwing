package Acwing._4枚举_模拟_排序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1231航班时间 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        while (n-- > 0) {
            int t = (getTime() + getTime()) / 2;//得到飞行时间 单位：秒
            //转化为 小时：分钟：秒
            int hour = t / 3600, min = t % 3600 / 60, second = t % 60;
            System.out.println(String.format("%02d", hour) + ":" + String.format("%02d", min) + ":" + String.format("%02d", second));
        }
    }

    //得到起飞降落时间差
    static int getTime() throws IOException {           // split() 的正则表达式 分割 ： 和 空格
        String s[] = br.readLine().split(":| ");//17:21:07 00:31:46 (+1) 用代码中 split(":| ") 可以切割为
        int day = 0;                                  //   17、21、07、00、31、46、(+1)
        if (s.length == 7) day = s[6].charAt(2) - '0';
        int h1 = Integer.parseInt(s[0]);
        int m1 = Integer.parseInt(s[1]);
        int s1 = Integer.parseInt(s[2]);
        int h2 = Integer.parseInt(s[3]);
        int m2 = Integer.parseInt(s[4]);
        int s2 = Integer.parseInt(s[5]);
        return getSecond(h2, m2, s2) - getSecond(h1, m1, s1) + day * 24 * 3600;
    }

    static int getSecond(int h, int m, int s) {
        return h * 3600 + 60 * m + s;
    }
}
