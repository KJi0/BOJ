package BOJ;

/*
BOJ 13549: 숨바꼭질 3
순간이동의 경우 시간이 소요되지 않는다.
큐에 넣는 순서대로 계산하기 때문에, 최단거리를 구하려면
시간이 적게 소요되는 순으로 넣을 것!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549 {
    static int N, K, min = Integer.MAX_VALUE;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(min);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{N, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int pos = cur[0];
            int t = cur[1];
            visited[pos] = true;

            if (pos == K) {
                min = Math.min(min, t);
                return;
            }

            if (pos * 2 <= 100000 && pos * 2 >= 0 && !visited[pos * 2])
                q.offer(new int[]{pos * 2, t});
            if (pos - 1 <= 100000 && pos - 1 >= 0 && !visited[pos - 1])
                q.offer(new int[]{pos - 1, t + 1});
            if (pos + 1 <= 100000 && pos + 1 >= 0 && !visited[pos + 1])
                q.offer(new int[]{pos + 1, t + 1});
        }
    }
}
