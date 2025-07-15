package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21610 {
    static int N, M;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    static Queue<Cloud> clouds = new LinkedList<>();

    static class Cloud {
        int x;
        int y;
        public Cloud(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clouds.add(new Cloud(N - 1, 0));
        clouds.add(new Cloud(N - 1, 1));
        clouds.add(new Cloud(N - 2, 0));
        clouds.add(new Cloud(N - 2, 1));

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());

            simul(d, s);
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += map[i][j];
            }
        }
        System.out.println(sum);
    }

    public static void simul(int dir, int dis) {
        for (Cloud cloud : clouds) {
            cloud.x = (N + cloud.x + dx[dir] * (dis % N)) % N;
            cloud.y = (N + cloud.y + dy[dir] * (dis % N)) % N;
            map[cloud.x][cloud.y]++;
        }

        while (!clouds.isEmpty()) {
            Cloud cloud = clouds.poll();

            int cnt = 0;
            for (int i = 1; i < 8; i += 2) {
                int nx = cloud.x + dx[i];
                int ny = cloud.y + dy[i];

                if (nx < N && ny < N && nx >= 0 && ny >= 0) {
                    if (map[nx][ny] > 0)
                        cnt++;
                }
            }
            map[cloud.x][cloud.y] += cnt;
            visited[cloud.x][cloud.y] = true;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] >= 2 && !visited[i][j]) {
                    clouds.add(new Cloud(i, j));
                    map[i][j] -= 2;
                }
            }
        }
        visited = new boolean[N][N];
    }
}