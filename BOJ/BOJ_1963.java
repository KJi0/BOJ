package BOJ;

/*
1963: 소수 경로
테라토스테네스의 체! 소수인 수의 배수를 모두 제거한다
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1963 {
    static int T;
    static boolean[] notPrime = new boolean[10000];

    static class Node {
        int num;
        int cnt;
        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 2; i < 10000; i++) {
            if (!notPrime[i]) {
                for (int j = i * i; j < 10000; j += i)
                    notPrime[j] = true;
            }
        }

        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int ans = bfs(A, B);
            if (ans == -1) System.out.println("Impossible");
            else System.out.println(ans);
        }
    }

    static int bfs(int a, int b) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(a, 0));
        boolean[] visited = new boolean[10000];
        visited[a] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int num = cur.num;
            int cnt = cur.cnt;

            if (num == b) {
                return cnt;
            }

            int n = num / 10 * 10;
            for (int i = 0; i < 10; i++) {
                int tmp = n + i;
                if (!visited[tmp] && !notPrime[tmp]) {
                    visited[tmp] = true;
                    q.offer(new Node(tmp, cnt + 1));
                }
            }

            n = (num / 100 * 100) + num % 10;
            for (int i = 0; i < 10; i++) {
                int tmp = n + i * 10;
                if (!visited[tmp] && !notPrime[tmp]) {
                    visited[tmp] = true;
                    q.offer(new Node(tmp, cnt + 1));
                }
            }

            n = (num / 1000 * 1000) + num % 100;
            for (int i = 0; i < 10; i++) {
                int tmp = n + i * 100;
                if (!visited[tmp] && !notPrime[tmp]) {
                    visited[tmp] = true;
                    q.offer(new Node(tmp, cnt + 1));
                }
            }

            n = num % 1000;
            for (int i = 1; i < 10; i++) {
                int tmp = n + i * 1000;
                if (!visited[tmp] && !notPrime[tmp]) {
                    visited[tmp] = true;
                    q.offer(new Node(tmp, cnt + 1));
                }
            }
        } return -1;
    }
}
