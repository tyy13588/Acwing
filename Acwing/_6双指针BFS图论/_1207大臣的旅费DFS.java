package Acwing._6双指针BFS图论;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _1207大臣的旅费DFS {
    static Scanner sc = new Scanner(System.in);
    static int N = 100010;
    static int[] dist = new int[N];//距离数组
    static List<Node>[] list = new ArrayList[N];//邻接表

    static class Node {
        int id, w;//每条边的 编号、长度

        public Node(int id, int w) {
            this.id = id;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int a, b, c;
        for (int i = 1; i <= n - 1; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            if (list[a] == null) list[a] = new ArrayList<>(); // new 一个动态数组存节点
            if (list[b] == null) list[b] = new ArrayList<>();
            list[a].add(new Node(b, c));//a 中加入 b的信息
            list[b].add(new Node(a, c));//b 中加入 a的信息
        }

        //找到 任意点x找到距离最远的y  此处 从1开始
        dfs(1, -1, 0);

        //找到距离 1号点 最远的点编号 max
        int max = 1;
        for (int i = 1; i <= n; i++) {
            if (dist[i] > dist[max]) max = i;
        }
        System.out.println("-------"+max +"----");

        //从找到距离1最大点的编号max 继续遍历
        dfs(max, -1, 0);
        for (int i = 1; i <= n; i++)
            if (dist[i] > dist[max]) max = i;
        System.out.println("-------"+max +"----");
        int s = dist[max];
        System.out.println(s * 10 + (s + 1L) * s / 2);// 10^5 * 10^5 可能爆int  注意数据类型long
    }

    private static void dfs(int curNode, int father, int distance) {
        dist[curNode] = distance;
        for (Node e : list[curNode]) {
            //不往回走 继续深搜遍历
            if (e.id != father) dfs(e.id, curNode, distance + e.w);
        }
    }
}
