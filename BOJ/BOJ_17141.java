package BOJ;

/*
BOJ 17141: 연구소 2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17141 {
    static class Node {
        int x, y, t;
        public Node(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    static int N, M, min = Integer.MAX_VALUE;
    static int emptyCnt = 0;
    static int[][] map;
    static Node[] selected;
    static List<Node> virus = new ArrayList<>();

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        selected = new Node[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) virus.add(new Node(j, i, 0));
                if (map[i][j] != 1) emptyCnt++;
            }
        }

        select(0, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    static void select(int cnt, int start) {
        if (cnt == M) {
            bfs();
            return;
        }

        for (int i = start; i < virus.size(); i++) {
            selected[cnt] = virus.get(i);
            select(cnt + 1, i + 1);
        }
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < M; i++) {
            Node v = selected[i];
            q.offer(new Node(v.x, v.y, 0));
            visited[v.y][v.x] = true;
        }

        int infected = M;
        int ans = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[ny][nx] || map[ny][nx] == 1) continue;

                visited[ny][nx] = true;
                infected++;
                ans = cur.t + 1;
                q.offer(new Node(nx, ny, cur.t + 1));
            }
        }

        if (infected == emptyCnt)
            min = Math.min(min, ans);
    }
}
