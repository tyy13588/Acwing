package Acwing._1递归与递推;

import java.io.BufferedReader;
import java.io.*;

public class _1208翻硬币 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] start;
    static char[] aim;

    public static void main(String[] args) throws IOException {
        start = br.readLine().toCharArray();
        aim = br.readLine().toCharArray();

        int count = 0;
        int n = start.length;
        for (int i = 0; i < n - 1; i++) {
            if (start[i] != aim[i]) {
                count++;
                turn(i);
                turn(i + 1);
            }
        }
        System.out.println(count);
    }
    private static void turn(int i) {//翻转
        if (start[i]=='*')start[i]='o';
        else start[i]='*';
    }
}
