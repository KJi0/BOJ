package BOJ;

/*
BOJ 14226: 이모티콘
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_14226 {
    static int S;
    static boolean[][] visited = new boolean[1001][1001];
    static int min = Integer.MAX_VALUE;

    public static class Node {
        int clipboard;
        int emoji;
        int cnt;

        public Node (int clipboard, int emoji, int cnt) {
            this.clipboard = clipboard;
            this.emoji = emoji;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());

        bfs();
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 1, 0));
        visited[0][1] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.emoji == S) {
                System.out.println(cur.cnt);
                return;
            }

            // 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
            q.offer(new Node(cur.emoji, cur.emoji, cur.cnt + 1));

            // 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
            if (cur.clipboard != 0 && cur.clipboard + cur.emoji <= S && !visited[cur.clipboard][cur.clipboard + cur.emoji]) {
                q.offer(new Node(cur.clipboard, cur.clipboard + cur.emoji, cur.cnt + 1));
                visited[cur.clipboard][cur.clipboard + cur.emoji] = true;
            }

            // 3. 화면에 있는 이모티콘 중 하나를 삭제한다.
            if (cur.emoji >= 1 && !visited[cur.clipboard][cur.emoji - 1]) {
                q.offer(new Node(cur.clipboard, cur.emoji - 1, cur.cnt + 1));
                visited[cur.clipboard][cur.emoji - 1] = true;
            }
        }
    }
}
