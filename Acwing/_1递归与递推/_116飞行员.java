package Acwing._1递归与递推;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class _116飞行员 {
    static boolean[][] status = new boolean[4][4];
    static boolean[][] backup = new boolean[4][4];
    static ArrayList<Pair> res = new ArrayList<>();
    static ArrayList<Pair> tepRes = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



    private static int get(int x, int y) {
        return x * 4 + y;
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 4; i++) {
            char[] line = br.readLine().toCharArray();
            Arrays.fill(backup[i], false);
            for (int j = 0; j < 4; j++) {
                if (line[j] == '-') {
                    status[i][j]=true;
                    backup[i][j]=true;
                }
            }
        }
        //枚举 所有情况
        for (int op = 0; op < 1 << 16; op++) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    status[i] =backup[i].clone();
                }
            }

        }
    }
}
