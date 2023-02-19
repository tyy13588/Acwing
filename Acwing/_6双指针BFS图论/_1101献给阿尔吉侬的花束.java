package Acwing._6双指针BFS图论;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _1101献给阿尔吉侬的花束 {
    static class PII { //保存坐标
        int x, y;

        public PII(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static final int N = 210;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] g = new char[N][N];//保存迷宫信息
    static int[][] dis = new int[N][N];//dis 存储起点到每个点的路径长度 同时当作判重 数组
    static int r, c;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] s = br.readLine().split(" ");
            r = Integer.parseInt(s[0]);
            c = Integer.parseInt(s[1]);// r 行 每行 c 个字符
            for (int i = 0; i < r; i++) {//一次读取一行
                g[i] = br.readLine().toCharArray();
            }
            PII start = null, end = null;//地图起点 终点
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    //枚举 地图找出 起点 终点

                    if (g[i][j] == 'S') start = new PII(i, j);
                    else if (g[i][j] == 'E') end = new PII(i, j);
                }
            }

            int distance = bfs(start, end);
            if (distance == -1) System.out.println("oop!");
            else System.out.println(distance);
        }
    }

    private static int bfs(PII start, PII end) {//BFS
        Queue<PII> queue = new LinkedList<>();//建立一个队列
        for (int i = 0; i < r; i++) Arrays.fill(dis[i], -1);//先把距离都初始化为-1，-1表示不可到达

        dis[start.x][start.y] = 0;//表示起点已经走过了，且距离起点为0
        queue.offer(start);//将起点放入队列

        int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};//建立数组 方便找到 上下左右 四个方向的元素
        while (!queue.isEmpty()) {//当队列非空
            PII t = queue.poll();//取出对头元素 并删除
            for (int i = 0; i < 4; i++) {//循环，让该点往上下左右四个方向走,扩展该点
                int x = t.x + dx[i], y = t.y + dy[i];//坐标走到相应的地方
                if (x < 0 || x >= r || y < 0 || y >= c) continue;//出界
                if (g[x][y] == '#') continue;//障碍物
                if (dis[x][y] != -1) continue;//之前已经遍历
                dis[x][y] = dis[t.x][t.y] + 1;//如果能走到，则这个点距离起点的距离是上一个点距离起点的距离+1
                if (end.x == x && end.y == y) return dis[x][y];//如果当前已经走到终点，直接返回当前dis
                //没结束 继续
                queue.offer(new PII(x, y));
            }
        }
        return -1;
    }
}
