package Acwing._7贪心;

import java.util.Arrays;
import java.util.Scanner;

public class _112雷达设备 {
    static Scanner sc = new Scanner(System.in);
    static int N = 1010;
    static Pair seg[] = new Pair[N];
    static double esp = 10e-6;

    static class Pair implements Comparable<Pair> {
        double l, r;

        public Pair(double l, double r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Pair o) {
            return Double.compare(this.r, o.r);
        }
    }

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();//小岛数
        int d = sc.nextInt();//雷达半径
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (y > d) {
                System.out.println("-1");
                return;
            }
            double len = Math.sqrt(d * d - y * y);
            //每个岛 投射到x轴上的左、右端点
            seg[i] = new Pair(x - len, x + len);

        }

        //对所有区间 排序
        Arrays.sort(seg, 1, n + 1);
  
        int res = 0;
        double lastNode = Integer.MIN_VALUE;  //上一个雷达位置
        //以上一个点的右端点 判断是否在当前区间的左端点内
        for (int i = 1; i <= n; i++) {
            if (seg[i].l > lastNode) {   //下一段区间的起始点在上一个雷达的右边 即没有交集 则需要加入新的雷达
                res++;
                lastNode = seg[i].r;//更新
            }
        }
        System.out.println(res);
    }
}
