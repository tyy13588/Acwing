package Acwing._4枚举_模拟_排序;

import java.util.Arrays;
import java.util.Scanner;

public class _1241外卖优先级 {
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
    static int K = 100010;
    static int priority[] = new int[K];//表示第i个店铺当前优先级
    static int last[] = new int[K];//表示第i个店铺上一次有订单的时刻
    static int st[] = new int[K];//表示第i个店铺当前是否在优先缓存中
    static PII[] order = new PII[K];//存储订单

    public static void main(String[] args) {
        int N = sc.nextInt(), M = sc.nextInt(), T = sc.nextInt();//N个店铺 M条订单信息 T时刻
        for (int i = 1; i <= M; i++)//存储订单信息
            order[i] = new PII(sc.nextInt(), sc.nextInt());
        //按订单时刻排序
        Arrays.sort(order, 1, M+1);

        //枚举每个订单
        for (int i = 1; i <= M; i++) {
            int t = order[i].ts, id = order[i].id;//拿到每个订单的 t id
            System.out.println(t+"__"+id);
            int j = i;
            while (j <= M && order[i].id == order[j].id && order[i].ts == order[j].ts) j++;///注意在 j时退出 下面要-1
            int cnt = j - i;  //拿到 当前店铺同一时刻的订单数量


            //处理t时刻有订单之前的状况
            priority[id] -= t - last[id] - 1;//列 2时刻有 3时刻无 4时刻无 5时刻有  ： 即 2个时刻无订单
            //特判
            if (priority[id] < 0) priority[id] = 0;
            if (priority[id] <= 3) st[id] = 0;
            i = j-1;//i直接后移到j-1 因为订单信息都一样 上面处理了

            //处理t时刻有订单情况
            priority[id] += cnt * 2;
            if (priority[id] > 5) st[id] = 1;
            last[id] = t;//记录当前 id店铺的 最后有订单时刻 t；
        }
        //枚举每个店铺最最后出现时刻 与 T时刻 检查是否存在 一段空时刻
        for (int i = 1; i <= N; i++) {
            if (last[i] < T) {
                priority[i] -= T - last[i];//不用-1 因为T时刻 没有订单
            }
            //检查每个店铺最终状态
            if (priority[i] <= 3) st[i] = 0;
        }

        int res = 0;
        for (int i = 1; i <= N; i++) res += st[i];
        System.out.println(res);
    }
}

