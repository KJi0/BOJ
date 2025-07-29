package BOJ;

/*
BOJ 17144: 미세먼지 안녕!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17144 {
    static int R, C, T;
    static int airU, airD;
    static int[][] map;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static class Point {
        int x;
        int y;
        int val;
        public Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            if (map[i][0] == -1) {
                airU = i;
                airD = i + 1;
                break;
            }
        }

        while (T-- > 0) {
            spread();
            purify();
        }

        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0)
                    sum += map[i][j];
            }
        }

        System.out.println(sum);
    }

    public static void spread() {
        Queue<Point> q = new LinkedList<>();
        int[][] tempMap = new int[R][C];

        // 미세먼지 위치
        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                if (map[x][y] > 0) {
                    q.offer(new Point(x, y, map[x][y]));
                }
            }
        }

        while(!q.isEmpty()) {
            Point now = q.poll();
            int amount = now.val / 5;
            int cnt = 0;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if (map[nx][ny] != -1) {
                        tempMap[nx][ny] += amount;
                        cnt++;
                    }
                }
            }
            tempMap[now.x][now.y] -= amount * cnt;
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] += tempMap[i][j];
            }
        }
    }

    public static void purify() {
        for (int x = airU - 1; x > 0; x--) {
            map[x][0] = map[x - 1][0];
        }
        for (int y = 0; y < C - 1; y++) {
            map[0][y] = map[0][y + 1];
        }
        for (int x = 0; x < airU; x++) {
            map[x][C - 1] = map[x + 1][C - 1];
        }
        for (int y = C - 1; y > 0; y--) {
            map[airU][y] = map[airU][y - 1];
        }
        map[airU][1] = 0;

        for (int x = airD + 1; x < R - 1; x++) {
            map[x][0] = map[x + 1][0];
        }
        for (int y = 0; y < C - 1; y++) {
            map[R - 1][y] = map[R - 1][y + 1];
        }
        for (int x = R - 1; x > airD; x--) {
            map[x][C - 1] = map[x - 1][C - 1];
        }
        for (int y = C - 1; y > 0; y--) {
            map[airD][y] = map[airD][y - 1];
        }
        map[airD][1] = 0;
    }
}