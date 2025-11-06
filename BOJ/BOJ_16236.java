package BOJ;

/*
BOJ 16236: 아기 상어
넘 어려워요...
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236 {
    static int N, ans = 0;
    static int curX, curY, size = 2, cnt = 0;
    static int[][] map;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            if (this.cnt == o.cnt) {
                if (this.y == o.y) {
                    return this.x - o.x;
                }
                return this.y - o.y;
            }
            return this.cnt - o.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 9) {
                    curX = j;
                    curY = i;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            int tmp = bfs();
            if (tmp == -1) break;
            ans += tmp;
            if (cnt == size) {
                cnt = 0;
                size++;
            }
        }

        System.out.println(ans);
    }

    static int bfs() {
        Queue<Node> q = new PriorityQueue<>();
        q.offer(new Node(curX, curY, 0));
        boolean[][] visited = new boolean[N][N];
        visited[curY][curX] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (map[cur.y][cur.x] != 0 && map[cur.y][cur.x] < size) {
                map[cur.y][cur.x] = 0;
                curX = cur.x;
                curY = cur.y;
                cnt++;
                return cur.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[ny][nx]) {
                    if (map[ny][nx] <= size) {
                        q.offer(new Node(nx, ny, cur.cnt + 1));
                        visited[ny][nx] = true;
                    }
                }
            }
        }
        return -1;
    }
}
