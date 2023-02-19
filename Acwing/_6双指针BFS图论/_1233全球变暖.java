package Acwing._6双指针BFS图论;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1233全球变暖 {
    static Scanner sc = new Scanner(System.in);
    static int N = 1010;
    static char g[][] = new char[N][N];
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};//四个方向的偏移量
    static boolean st[][] = new boolean[N][N];
    static int n = 0;

    static class PII {//保存坐标
        int x, y;

        public PII(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {//处理输入
            char[] c = sc.next().toCharArray();
            for (int j = 0; j < n; j++) {
                g[i][j] = c[j];
            }
        }
        int cnt = 0;//统计结果
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!st[i][j] && g[i][j] == '#') {//当前位置没访问过  且 以该陆地进行 宽搜
                    if (bfs(i, j)) cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    private static boolean bfs(int x, int y) {
        int total = 0, bound = 0;//当前位置连通陆地的数量    被淹没陆地的数量
        Queue<PII> queue = new LinkedList<>();        //初始化 队列
        queue.offer(new PII(x, y));//加入队列
        st[x][y] = true;//当前点 标记访问过
        while (!queue.isEmpty()) {//队列非空
            PII t = queue.poll();//取出头节点 并删除
            total++;
            boolean is_bound = false;//判断 岛屿 是否被淹没
            for (int i = 0; i < 4; i++) {
                int a = t.x + dx[i], b = t.y + dy[i];//拓展四个方向的点
                if (a < 0 && a >= n && b < 0 && b >= n) continue;//超出边界
                if (st[a][b]) continue;//已访问过
                if (g[a][b] == '.') {
                    is_bound = true;
                    continue;
                }
                queue.add(new PII(a, b));
                st[a][b] = true;
            }
            if (is_bound) bound++;//拓展四个方向后 发现有与 海相连
        }
        return total == bound;
    }
}

