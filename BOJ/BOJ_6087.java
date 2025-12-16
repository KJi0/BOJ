package BOJ;

/*
BOJ 6087: 레이저 통신
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_6087 {
    static int W, H;
    static Node[] C = new Node[2];
    static char[][] map;
    static int[][] cost;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Node implements Comparable<Node> {
        int x, y, dir, mirror;

        public Node(int x, int y, int dir, int mirror) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.mirror = mirror;
        }

        @Override
        public int compareTo(Node o) {
            return this.mirror - o.mirror;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken()); // 열
        H = Integer.parseInt(st.nextToken()); // 행
        map = new char[H][W];

        int idx = 0;
        for (int i = 0; i < H; i++) {
            String str = br.readLine();
            map[i] = str.toCharArray();
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 'C') {
                    C[idx++] = new Node(i, j, -5, -1);
                }
            }
        }

        System.out.println(bfs(C[0]));
    }

    static int bfs(Node start) {
        int min = Integer.MAX_VALUE;
        Node end = C[1];
        // "이동수 최소"가 아닌 "가중치 최소"이기 때문에 우선순위 큐 사용
        PriorityQueue<Node> q = new PriorityQueue<>();

        // 미방문 처리
        int[][][] visited = new int[4][H][W];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < H; j++) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }

        q.offer(start);

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.x == end.x && cur.y == end.y) {
                min = Math.min(min, cur.mirror);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nX = cur.x + dx[i];
                int nY = cur.y + dy[i];
                int nM = (cur.dir == i) ? cur.mirror : cur.mirror + 1;

                if (nX < 0 || nX >= H || nY < 0 || nY >= W) continue;
                if (map[nX][nY] == '*') continue;
                // 방문한 노드여도 더 적은 비용이면 갱신
                if (visited[i][nX][nY] > nM) {
                    q.offer(new Node(nX, nY, i, nM));
                    visited[i][nX][nY] = nM;
                }
            }
        }
        return min;
    }
}
