package Acwing._4枚举_模拟_排序;

import java.util.Scanner;

public class 超级质数 {

    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int max = 3;

        for (int i = 3; i < 10000; i++) {
            //不是质数 continue
            if (!isPrime(i)) continue;
            //是质数 解析字串
            boolean flag = true;
            int[] strArr = strNum(String.valueOf(i));
            for (int j = 0; j < strArr.length; j++) {
                if (!isPrime(strArr[j])) {
                    flag = false;
                    break;
                }
            }
            if (!flag) continue;
            //所有字串满足素数
            max = i;
        }
        System.out.println(max);
    }

    static boolean isPrime(int num) {
        for (int i = 2; i < num - 1; i++)
            if (num % i == 0) return false;
        return true;
    }

    static int[] strNum(String s) {
        int arr[] = new int[121];
        String s2 = "";
        int k = 0;
        for (int i = 0; i < s.length(); i++) {//枚举起点
            for (int j = i; j < s.length(); j++) {//枚举终点
                s2 = s.substring(i, j + 1);
                arr[k++] = Integer.parseInt(s2);
            }
        }
        return arr;
    }
}
