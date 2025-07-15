package BOJ;

/*
BOJ 3190: 뱀
어렵다... ;-;
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_3190 {
    static int N, K, L;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static Deque<Point> snake = new ArrayDeque<>();
    static HashMap<Integer, String> turns = new HashMap<>();

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = 1; // 사과 위치
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            turns.put(t, dir);
        }

        simul();
    }

    public static void simul() {
        int time = 0;
        int d = 0;
        int cx = 0, cy = 0;
        snake.addLast(new Point(0, 0));
        map[0][0] = -1; // 뱀 위치

        while (true) {
            time++;

            int nx = cx + dx[d];
            int ny = cy + dy[d];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == -1) {
                break;
            }

            if (map[nx][ny] == 1) {
                map[nx][ny] = -1;
                snake.addLast(new Point(nx, ny));
            } else {
                map[nx][ny] = -1;
                snake.addLast(new Point(nx, ny));
                Point tail = snake.removeFirst();
                map[tail.x][tail.y] = 0;
            }

            if (turns.containsKey(time)) {
                if (turns.get(time).equals("L")) {
                    d = (d + 3) % 4; // (d - 1) % 4는 음수 인덱스 위험
                } else d = (d + 1) % 4;
            }
            cx = nx;
            cy = ny;
        }
        System.out.println(time);
    }
}