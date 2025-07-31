package BOJ;

/*
BOJ 17140: 이차원 배열과 연산
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17140 {
    static class Node implements Comparable<Node> {
        int num;
        int cnt;
        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        public int compareTo(Node o) {
            if (this.cnt == o.cnt) {
                return this.num - o.num;
            }
            return this.cnt - o.cnt;
        }
    }

    static int r, c, k;
    static int row, col;
    static int[][] A = new int[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int t = 0;
        row = 3; col = 3;
        while (true) {
            if (t > 100) {
                t = -1;
                break;
            }

            if (r < row && c < col && A[r][c] == k)
                break;

            t++;
            if (row >= col)
                operationR();
            else
                operationC();
        }
        System.out.println(t);
    }

    public static void operationR() {
        HashMap<Integer, Integer>[] map = new HashMap[row];
        ArrayList<Node> nodes[] = new ArrayList[row];

        int maxC = 0;
        for (int i = 0; i < row; i++) {
            if (i >= 100) break;
            map[i] = new HashMap<Integer, Integer>();
            nodes[i] = new ArrayList<Node>();

            for (int j = 0; j < col; j++) {
                if (j >= 100) break;

                int cur = A[i][j];
                if (cur == 0) continue;
                if (map[i].containsKey(cur))
                    map[i].put(cur, map[i].get(cur) + 1);
                else
                    map[i].put(cur, 1);
            }
            maxC = Math.max(maxC, map[i].size());
            for (Integer x : map[i].keySet()) {
                nodes[i].add(new Node(x, map[i].get(x)));
            }
        }
        col = maxC * 2;
        A = new int[row][col];
        for (int i = 0; i < row; i++) {
            Collections.sort(nodes[i]);
            int idx = 0;
            for (int j = 0; j < nodes[i].size(); j++) {
                A[i][idx++] = nodes[i].get(j).num;
                A[i][idx++] = nodes[i].get(j).cnt;
            }
        }
    }

    public static void operationC() {
        HashMap<Integer, Integer>[] map = new HashMap[col];
        ArrayList<Node> nodes[] = new ArrayList[col];

        int maxR = 0;
        for (int i = 0; i < col; i++) {
            if (i >= 100) break;

            map[i] = new HashMap<Integer, Integer>();
            nodes[i] = new ArrayList<Node>();

            for (int j = 0; j < row; j++) {
                int cur = A[j][i];
                if (cur == 0) continue;
                if (map[i].containsKey(cur)) {
                    map[i].put(cur, map[i].get(cur) + 1);
                } else
                    map[i].put(cur, 1);
            }
            maxR = Math.max(maxR, map[i].size());
            for (Integer x : map[i].keySet()) {
                nodes[i].add(new Node(x, map[i].get(x)));
            }
        }
        row = maxR * 2;
        A = new int[row][col];
        for (int i = 0; i < col; i++) {
            int idx = 0;
            Collections.sort(nodes[i]);
            for (int j = 0; j < nodes[i].size(); j++) {
                A[idx++][i] = nodes[i].get(j).num;
                A[idx++][i] = nodes[i].get(j).cnt;
            }
        }
    }
}