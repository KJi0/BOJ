package BOJ;

/*
BOJ 2234: 성곽
아 좌표 헷갈린다...
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2234 {
    static int N, M, max = Integer.MIN_VALUE;
    static int[] area;
    static int[][] map, roomId;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 열
        M = Integer.parseInt(st.nextToken()); // 행

        area = new int[2501];
        map = new int[M][N];
        roomId = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 1;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (roomId[i][j] == 0) {
                    bfs(j, i, cnt);
                    max = Math.max(max, area[cnt]);
                    cnt++;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int d = 0; d < 4; d++) {
                    int nx = j + dx[d];
                    int ny = i + dy[d];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && (roomId[i][j] != roomId[ny][nx])) {
                        sum = Math.max(sum, area[roomId[i][j]] + area[roomId[ny][nx]]);
                    }
                }
            }
        }
        System.out.println(cnt - 1);
        System.out.println(max);
        System.out.println(sum);
    }

    static void bfs(int x, int y, int cnt) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        roomId[y][x] = cnt;
        boolean[][] visited = new boolean[M][N];
        visited[y][x] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            area[cnt]++;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if ((map[cur.y][cur.x] & (1 << i)) == 0) {
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[ny][nx]) {
                        q.offer(new Node(nx, ny));
                        roomId[ny][nx] = cnt;
                        visited[ny][nx] = true;
                    }
                }


            }
        }
    }

    static class Node {
        int x;
        int y;
        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
