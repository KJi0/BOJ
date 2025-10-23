package BOJ;

/*
BOJ 1697: 숨바꼭질
최단 시간, 카운트를 세야 할 때는 BFS?
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {
    static int N, K, ans = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];

        bfs(N);

        System.out.println(ans);
    }

    static void bfs(int X) {
        Queue<int[]> q = new LinkedList<>();
        visited[X] = true;
        q.offer(new int[]{X, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int pos = cur[0];
            int t = cur[1];

            if (pos == K) {
                ans = t;
                return;
            }

            int[] dir = {pos + 1, pos - 1, pos * 2};
            for (int d : dir) {
                if (d >= 0 && d < 100001 && !visited[d]) {
                    q.offer(new int[]{d, t + 1});
                    visited[d] = true;
                }
            }
        }
    }
}