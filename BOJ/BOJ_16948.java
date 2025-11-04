package BOJ;

/*
BOJ 16948: 데스 나이트
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16948 {
    static int N, r1, c1, r2, c2;
    static boolean[][] visited;
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};

    static class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        bfs();
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r1, c1, 0));
        visited[r1][c1] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int r = cur.x;
            int c = cur.y;
            int cnt = cur.cnt;

            if (r == r2 && c == c2) {
                System.out.println(cnt);
                return;
            }

            for (int d = 0; d < 6; d++) {
                int nx = r + dx[d];
                int ny = c + dy[d];

                if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                    if (!visited[nx][ny]) {
                        q.add(new Node(nx, ny, cnt + 1));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
