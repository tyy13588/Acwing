package Acwing._6双指针BFS图论;

import java.util.Arrays;
import java.util.Scanner;

public class _1238日志统计 {
    static class PII implements Comparable<PII> {
        int ts, id;

        public PII(int ts, int id) {
            this.ts = ts;
            this.id = id;
        }

        @Override
        public int compareTo(PII o) {
            if (this.ts > o.ts) return 1;
            if (this.ts == o.ts) {
                if (this.id > o.id) return 1;
                else return -1;
            }
            return -1;
        }
    }

    static Scanner sc = new Scanner(System.in);
    static PII logs[] = new PII[100010];//保存 记录
    static int cnt[] = new int[100010];//用来记录一个id号获得的赞数，表示形式为cnt[id]++;
    static boolean st[] = new boolean[100010];//用来标记id号，因为id <= 1e5，所以可以利用遍历来输出。

    public static void main(String[] args) {
        int N = sc.nextInt(), D = sc.nextInt(), K = sc.nextInt();//N行数据 时间长度为D 不少于K个赞
        for (int i = 0; i < N; i++)
            logs[i] = new PII(sc.nextInt(), sc.nextInt());
        Arrays.sort(logs, 0, N);//按时间 排序处理

        //双指针算法  i走的块 j在后面跟着
        for (int i = 0, j = 0; i < N; i++) {
            int i_id = logs[i].id;//表示i时刻的id号
            cnt[i_id]++;

            while (logs[i].ts - logs[j].ts >= D) {//两指针跨越时间超过D 去除早期 赞的记录
                cnt[logs[j].id]--;
                j++;//后移遍历
            }

            if (cnt[i_id] >= K) st[i_id] = true;//记录i_id 是否为 热赞 如果是热帖 标记为true
        }

        for (int i = 0; i < 100010; i++)
            if (st[i]) System.out.println(i);
    }
}
