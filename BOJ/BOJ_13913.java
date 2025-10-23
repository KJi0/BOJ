package BOJ;

/*
BOJ 13913: 숨바꼭질 4
dir 3가지 모두 부모 노드는 같으니,
부모를 저장해서 스택 역추적 활용하자!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_13913 {
    static int N, K, ans = 0;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        parent = new int[100001];
        visited = new boolean[100001];

        if (N == K) {
            System.out.println(0);
            System.out.println(N);
            return;
        }

        bfs(N);

        StringBuilder sb = new StringBuilder();
        sb.append(ans + "\n");

        Stack<Integer> s = new Stack<>();
        s.push(K);
        int idx = K;
        while (idx != N) {
            s.push(parent[idx]);
            idx = parent[idx];
        }

        while (!s.isEmpty()) {
            sb.append(s.pop() + " ");
        }
        System.out.println(sb);
    }

    static void bfs(int X) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{X, 0});
        visited[X] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int pos = cur[0];
            int t = cur[1];

            if (pos == K) {
                ans = t;
                return;
            }

            int[] dir = {pos - 1, pos + 1, pos * 2};
            for (int d : dir) {
                if (d >= 0 && d <= 100000 && !visited[d]) {
                    q.offer(new int[]{d, t + 1});
                    visited[d] = true;
                    parent[d] = pos;
                }
            }
        }
    }
}
