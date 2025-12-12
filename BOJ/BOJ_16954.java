package BOJ;

/*
BOJ 16954: 움직이는 미로 탈출
BFS에서 '같은 시간 내'의 큐 탐색 해야 할 때는
q.size 동안 반복문 돌리기!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_16954 {
    static char[][] map = new char[8][8];
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1, 0};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1, 0};

    static class Node {
        int x; int y;
        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 8; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> avatar = new LinkedList<>();
        avatar.offer(new Node(7, 0));

        while (!avatar.isEmpty()) {
            int size = avatar.size();

            for (int i = 0; i < size; i++) {
                Node cur = avatar.poll();

                if (cur.x == 0 && cur.y == 7) return 1;
                if (map[cur.x][cur.y] == '#') continue;

                for (int d = 0; d < 9; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];

                    if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8) continue;
                    if (map[nx][ny] == '#') continue;

                    avatar.offer(new Node(nx, ny));
                }
            }

            for (int i = 6; i >= 0; i--) {
                for (int j = 0; j < 8; j++) {
                    map[i + 1][j] = map[i][j];
                }
            }

            for (int i = 0; i < 8; i++) {
                map[0][i] = '.';
            }
        }
        return 0;
    }
}
