package BOJ;

/*
BOJ 14502: 연구소
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BOJ_14502 {
    static int N, M;
    static int[][] map, copyMap;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int max = Integer.MIN_VALUE;
    public static Queue<virus> q = new LinkedList<virus>();

    static class virus {
        int x;
        int y;
        public virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(max);
    }
    // 벽 세우기
    public static void dfs(int wall) {
        if (wall == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
    // 바이러스 퍼트리고 안전 영역 찾기
    public static void bfs() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2)
                    q.offer(new virus(i, j));
            }
        }

        copyMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            copyMap[i] = map[i].clone();
        }

        while (!q.isEmpty()) {
            virus v = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = v.x + dx[i];
                int ny = v.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (copyMap[nx][ny] == 0) {
                        copyMap[nx][ny] = 2;
                        q.offer(new virus(nx, ny));
                    }
                }
            }
        }
        findSafeZone(copyMap);
    }

    public static void findSafeZone(int[][] copyMap) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0)
                    cnt++;
            }
        }
        max = Math.max(cnt, max);
    }
}