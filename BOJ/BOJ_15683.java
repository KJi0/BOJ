package BOJ;

/*
BOJ 15683: 감시
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15683 {
    static class CCTV {
        int x, y, num;

        public CCTV(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    static int N, M;
    static int answer = Integer.MAX_VALUE;
    static int[][] map;
    static ArrayList<CCTV> cctvs = new ArrayList<>();
    // 오른쪽:0, 아래쪽:1, 왼쪽:2, 위쪽:3
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] dir = {
            {},
            {0},
            {0, 2},
            {0, 3},
            {0, 2, 3},
            {0, 1, 2, 3}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0 && map[i][j] < 6)
                    cctvs.add(new CCTV(i, j, map[i][j]));
            }
        }

        dfs(0, map);
        System.out.println(answer);
    }

    public static void dfs(int depth, int[][] map) {
        if (depth == cctvs.size()) {
            answer = Math.min(answer, getBlindSpot(map));
            return;
        }

        int x = cctvs.get(depth).x;
        int y = cctvs.get(depth).y;
        int num = cctvs.get(depth).num;

        for (int d = 0; d < 4; d++) {
            int[][] copyMap = new int[N][M];

            for (int i = 0; i < N; i++) {
                copyMap[i] = map[i].clone();
            }

            for (int dir : dir[num]) {
                int nd = (dir + d) % 4;
                int nx = x + dx[nd];
                int ny = y + dy[nd];

                while (true) {
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) break;
                    if (map[nx][ny] == 6) break;

                    copyMap[nx][ny] = -1;
                    nx += dx[nd];
                    ny += dy[nd];
                }
            }
            dfs(depth + 1, copyMap);
        }
    }

    public static int getBlindSpot(int[][] copyMap) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0)
                    cnt++;
            }
        }
        return cnt;
    }
}
