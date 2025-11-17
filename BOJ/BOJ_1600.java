package BOJ;

/*
BOJ 1600: 말이 되고픈 원숭이
map[행][열] == map[y][x]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600 {
    static int K, W, H;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static int[] hx = {2, 2, 1, 1, -1, -1, -2, -2};
    static int[] hy = {1, -1, 2, -2, 2, -2, 1, -1};

    static class Node {
        int x;
        int y;
        int cnt;
        int chance;
        public Node (int x, int y, int cnt, int chance) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.chance = chance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 0, 0));
        boolean[][][] visited = new boolean[H][W][K + 1];
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.x == W - 1 && cur.y == H -1) {
                return cur.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < W && ny >= 0 && ny < H) {
                    if (map[ny][nx] == 0) {
                        if (!visited[ny][nx][cur.chance]) {
                            q.offer(new Node(nx, ny, cur.cnt + 1, cur.chance));
                            visited[ny][nx][cur.chance] = true;
                        }
                    }
                }
            }

            if (cur.chance < K) {
                for (int i = 0; i < 8; i++) {
                    int nx = cur.x + hx[i];
                    int ny = cur.y + hy[i];

                    if (nx >= 0 && nx < W && ny >= 0 && ny < H) {
                        if (map[ny][nx] == 0) {
                            if (!visited[ny][nx][cur.chance + 1]) {
                                q.offer(new Node(nx, ny, cur.cnt + 1, cur.chance + 1));
                                visited[ny][nx][cur.chance + 1] = true;
                            }
                        }
                    }
                }
            }
        } return -1;
    }
}