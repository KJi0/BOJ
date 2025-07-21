package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500 {
    static int N, M;
    static int[][] map;
    static boolean[][] visit;
    static int max = Integer.MIN_VALUE;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = true;
                dfs(i, j, map[i][j], 1);
                visit[i][j] = false;
            }
        }

        System.out.println(max);
    }

    public static void dfs(int x, int y, int sum, int depth) {
        if (depth == 4) {
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (!visit[nx][ny]) {
                    if (depth == 2) {
                        visit[nx][ny] = true;
                        dfs(x, y, sum + map[nx][ny], depth + 1);
                        visit[nx][ny] = false;
                    }
                    visit[nx][ny] = true;
                    dfs(nx, ny, sum + map[nx][ny], depth + 1);
                    visit[nx][ny] = false;
                }
            }
        }
    }

    /*
    public static void check(int x, int y) {
        if (x + 1 < N && y + 2 < M) // ㅜ
            max = Math.max(max,map[x][y] + map[x][y + 1] + map[x][y + 2] + map[x + 1][y + 1]);
        if (x + 2 < N && y + 1 < M) // ㅏ
            max = Math.max(max, map[x][y] + map[x + 1][y] + map[x + 2][y] + map[x + 1][y + 1]);
        if (x + 2 < N && y - 1 >= 0) // ㅓ
            max = Math.max(max, map[x][y] + map[x + 1][y] + map[x + 2][y] + map[x + 1][y - 1]);
        if (x - 1 >= 0 && y + 2 < M) // ㅗ
            max = Math.max(max, map[x][y] + map[x][y + 1] + map[x][y + 2] + map[x - 1][y + 1]);
    }
     */
}
