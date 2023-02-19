package Acwing._6双指针BFS图论;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static Acwing._6双指针BFS图论._1101献给阿尔吉侬的花束.br;

public class _1096地牢大师 {
    static Scanner sc = new Scanner(System.in);
    static char g[][][] = new char[110][110][110];//保存地牢信息
    static int distance[][][] = new int[110][110][110];//计算步数
    static int[] dx = {1, -1, 0, 0, 0, 0}, dy = {0, 0, 1, -1, 0, 0}, dz = {0, 0, 0, 0, 1, -1};//上下左右前后 六个方向 的偏移坐标
    static int L, R, C;

    static class point {//保存 坐标信息
        int x, y, z;

        public point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            // 地牢层数 行 列数
            L = sc.nextInt();
            R = sc.nextInt();
            C = sc.nextInt();
            if (L == 0 & R == 0 && C == 0) break;
            point start = null, end = null;
            //读入地牢信息
            for (int z = 1; z <= L; z++) {//当前地牢层数
                for (int x = 1; x <= R; x++) {
                    String s = br.readLine();
                    for (int y = 1; y <= C; y++) {
                        g[z][x][y] = s.charAt(y - 1);
                        if (g[z][x][y] == 'S') start = new point(z, x, y);
                        else if (g[z][x][y] == 'E') end = new point(z, x, y);
                    }
                    //遍历地图 找到起点和 终点

                }
                br.readLine();
            }
            int distance = bfs(start, end);
            if (distance == -1) System.out.println("Trapped!");
            else System.out.println("Escaped in" + distance + " minute(s).");
        }
    }

    //广度搜索思想
    private static int bfs(point start, point end) {
        Queue<point> queue = new LinkedList<>();//建立队列
        queue.offer(start);//加入对头元素
        //初始化
//        for (int i = 0; i < L; i++)
//            for (int j = 0; j < R; j++)
//                Arrays.fill(distance[i][j], -1);
//                for (int k = 0; k < C; k++)
//                    distance[i][j][k] = -1;


        distance[start.x][start.y][start.z] = 0;

        while (!queue.isEmpty()) {//当队列非空
            point t = queue.poll();//取出对头元素，并删除
            for (int i = 0; i < 6; i++) {//循环 让该点向六个方向走 进行拓展
                int x = t.x + dx[i], y = t.y + dy[i], z = t.z + dz[i];
                if (x <= 0 || x >= L || y <= 0 || y >= R || z <= 0 || z >= C) continue;//出界
                if (g[x][y][z] == '#') continue;//有障碍物
                if (g[x][y][z] != -1) continue;//之前走过
                //没走过 更新
                distance[x][y][z] = distance[t.x][t.y][t.z] + 1;
                if (x == end.x && y == end.y && z == end.z) {
                    return distance[x][y][z];
                }
                //没到终点 继续将头节点 相连元素 加入队尾
                queue.offer(new point(x, y, z));
            }
        }
        return -1;
    }
}

