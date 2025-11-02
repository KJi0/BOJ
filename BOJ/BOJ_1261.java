package BOJ;

/*
BOJ 1261: 알고스팟
벽을 최대한 적게 부숴야 하므로 우선순위 큐를 쓸 것!!

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int x;
    int y;
    int wallcnt;

    public Node(int x, int y, int wallcnt) {
        this.x = x;
        this.y = y;
        this.wallcnt = wallcnt;
    }

    @Override
    public int compareTo(Node o) {
        return wallcnt - o.wallcnt;
    }
}

public class BOJ_1261 {
    static int N, M;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];

        for (int x = 1; x <= N; x++) {
            String input = br.readLine();
            for (int y = 1; y <= M; y++) {
                map[x][y] = input.charAt(y - 1) - '0';
            }
        }

        int ans = bfs();
        System.out.println(ans);
    }

    static int bfs() {
        Queue<Node> q = new PriorityQueue<>();
        boolean[][] visited = new boolean[N + 1][M + 1];
        q.offer(new Node(1, 1, 0));
        visited[1][1] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;
            int wallcnt = cur.wallcnt;

            if (curX == N && curY == M) {
                return wallcnt;
            }

            for (int d = 0; d < 4; d++) {
                int nx = curX + dx[d];
                int ny = curY + dy[d];

                if (nx <= N && nx > 0 && ny <= M && ny > 0 && !visited[nx][ny]) {
                    if (map[nx][ny] == 1) {
                        q.offer(new Node(nx, ny, wallcnt + 1));
                        visited[nx][ny] = true;
                    }

                    if (map[nx][ny] == 0) {
                        q.offer(new Node(nx, ny, wallcnt));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return 0;
    }
}
