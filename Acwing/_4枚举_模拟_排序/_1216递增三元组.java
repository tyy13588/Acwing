package Acwing._4枚举_模拟_排序;

import java.util.Arrays;
import java.util.Scanner;

public class _1216递增三元组 {
    static Scanner sc = new Scanner(System.in);
    static int N = 100010;
    static int a[] = new int[N];
    static int b[] = new int[N];
    static int c[] = new int[N];

    static int cnt[] = new int[N];//cnt[i]表示在A数组中i这个值出现次数
    static int cnt1[] = new int[N];//cnt[i]表示在C数组中i这个值出现次数
    static int as[] = new int[N];//as[i]表示在a[]中有多少个数字小于b[i]
    static int cs[] = new int[N];//cs[i]表示在c[]中有多少个数字大于b[i]
    static int s[] = new int[N];//前缀和数组 s[i]表示cnt[o]+cnt[1]+……+cnt[i] 即在A中0~i出现的次数
    static int s1[] = new int[N];//前缀和数组 s[i]表示cnt[o]+cnt[1]+……+cnt[i] 即在B中0~i出现的次数

    public static void main(String[] args) {
        int n = sc.nextInt();


        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            a[i]++;
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
            b[i]++;
        }
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
            c[i]++;
        }

        //求as[]
        for (int i = 0; i < n; i++) cnt[a[i]]++;//记录a[i]出现的次数
        for (int i = 1; i < N; i++) s[i] = s[i - 1] + cnt[i];//求cnt[]的前缀和
        for (int i = 0; i < n; i++) as[i] = s[b[i] - 1];

        //求cs[i]
        for (int i = 0; i < n; i++) cnt1[c[i]]++;//记录c[i]出现的次数
        for (int i = 1; i < N; i++) s1[i] = s1[i - 1] + cnt1[i];
        for (int i = 0; i < n; i++) cs[i] = s1[N - 1] - s1[b[i]];

        //枚举每个b[i]
        long res = 0;
        for (int i = 0; i < n; i++) res += (long) as[i] * cs[i];

        System.out.println(res);
    }

    /**
     * 二分
     */
//    public static void main(String[] args) {
//        int N = sc.nextInt();
//        int a[] = new int[N];
//        int b[] = new int[N];
//        int c[] = new int[N];
//        for (int i = 0; i < N; i++)
//            a[i] = sc.nextInt();
//        for (int i = 0; i < N; i++)
//            b[i] = sc.nextInt();
//        for (int i = 0; i < N; i++)
//            c[i] = sc.nextInt();
//        Arrays.sort(a);
//        Arrays.sort(b);
//        Arrays.sort(c);
//        long res = 0;// 注意 long  最终结果数据量很大
//        for (int i = 0; i < N; i++) {  // a < b < c 遍历数组b只需要一次循
//            long ai = 0, ci = 0;
//            int l = 0, r = N - 1;
//            //二分查找 满足 a[i]<b[i] 的元素索引
//            while (l < r) {
//                int mid = l + r + 1 >> 1;
//                if (a[mid] < b[i]) l = mid;
//                else r = mid - 1;
//            }
//            if (a[l] >= b[i]) continue;//特殊 即所有数都不满足时
//            //保存满足条件的a[]中个数 即索引数+1
//            ai = l + 1;
//            //恢复
//            l = 0;
//            r = N - 1;
//            //二分查找 满足 c[i]>b[i] 的元素索引
//            while (l < r) {
//                int mid = l + r >> 1;
//                if (c[mid] > b[i]) r = mid;
//                else l = mid + 1;
//            }
//            if (c[l] <= b[i]) l = N;//结束数字都小于n 取 N是为了使得 N-l为0 便于运算  (continue一样)
//            ci = N - l;     //保存满足条件的c[]中个数 即N-l
//            res += ai * ci;
//        }
//        System.out.println(res);
//    }
}
