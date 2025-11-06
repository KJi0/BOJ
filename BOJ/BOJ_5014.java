package BOJ;

/*
BOJ 5014: 스타트링크
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014 {
    static int F, S, G, U, D;
    static int min = Integer.MAX_VALUE;
    static int[] cnt, dir;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken()); // 가장 높은 층
        S = Integer.parseInt(st.nextToken()); // S층에서
        G = Integer.parseInt(st.nextToken()); // G층으로
        U = Integer.parseInt(st.nextToken()); // 위로 U층
        D = Integer.parseInt(st.nextToken()); // 아래로 D층

        dir = new int[]{U, -D};
        cnt = new int[F + 1];
        bfs(S);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        boolean[] visited = new boolean[F + 1];
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == G) {
                System.out.println(cnt[cur]);
                return;
            }

            for (int i = 0; i < 2; i++) {
                int next = cur + dir[i];

                if (next > 0 && next <= F && !visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                    cnt[next] = cnt[cur] + 1;
                }
            }
        }
        System.out.println("use the stairs");
    }
}
