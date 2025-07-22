package BOJ;

/*
BOJ 16234: 인구 이동
어려워요... 눈물...
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234 {
    static int N, L, R, cnt = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] country;
    static boolean[][] visited;
    static ArrayList<Point> union;

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
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        country = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                country[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(move());
    }

    public static int move() {
        int result = 0;
        while(true) {
            boolean isMove = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j]) {
                        int sum = bfs(i, j);
                        if (union.size() > 1) {
                            changePopulation(sum);
                            isMove = true;
                        }
                    }
                }
            }
            if (!isMove) return result;
            result++;
        }
    }

    public static int bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        union = new ArrayList<>();

        q.offer(new Point(x, y));
        union.add(new Point(x, y));
        visited[x][y] = true;

        int sum = country[x][y];
        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    int sub = Math.abs(country[cur.x][cur.y] - country[nx][ny]);
                    if (sub >= L && sub <= R && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new Point(nx, ny));
                        union.add(new Point(nx, ny));
                        sum += country[nx][ny];
                    }
                }
            }
        }
        return sum;
    }

    public static void changePopulation(int sum) {
        int people = sum / union.size();
        for (Point p : union) {
            country[p.x][p.y] = people;
        }
    }
}