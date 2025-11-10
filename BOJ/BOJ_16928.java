package BOJ;

/*
BOJ 16928: 뱀과 사다리 게임
방문 처리 위치 잘 파악하자...
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928 {
    static int N, M;
    static int[] map = new int[101];
    static int[] cnt = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x] = y;
        }

        bfs();
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        boolean[] visited = new boolean[101];
        visited[1] = true;
        cnt[1] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == 100) {
                System.out.println(cnt[100]);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int next = cur + i;

                if (next <= 100 && !visited[next]) {
                    visited[next] = true;

                    if (map[next] != 0) { // 사다리/뱀이 있는 경우
                        if (!visited[map[next]]) {
                            q.offer(map[next]);
                            visited[map[next]] = true;
                            cnt[map[next]] = cnt[cur] + 1;
                        }
                    } else { // 사다리/뱀이 없는 경우
                        q.offer(next);
                        cnt[next] = cnt[cur] + 1;
                    }
                }
            }
        }
    }
}
