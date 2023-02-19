package Acwing._2二分与前缀和;

import java.io.*;
import java.util.HashMap;

public class _1221四平方和 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        //将 c*c+d*d 结果存入hashmap
        for (int c = 0; c * c <= n; c++)
            for (int d = c; c * c + d * d <= n; d++) {
                if (!map.containsKey(c * c + d * d))//若哈希表中不存在的话 则存进去 （保证了字典序）
                    map.put(c * c + d * d, c);
            }
        //枚举符合条件的前两项
        for (int a = 0; a * a <= n; a++) {
            for (int b = a; a * a + b * b <= n; b++) {
                int t = n - a * a - b * b;
                if (map.containsKey(t)) {
                    int c = map.get(t);
                    int d = (int) Math.sqrt(n - a * a - b * b - c * c);
                    System.out.println(a + " " + b + " " + c + " " + d);
                    return;
                }
            }
        }
    }
}


