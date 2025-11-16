package BOJ;

/*
BOJ 14395: 4연산
늘 수의 범위를 잘 고려할 것!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14395 {
    static int s, t;
    static int max = 1_000_000_000;

    static class Node {
        int num;
        String op;
        public Node (int num, String op) {
            this.num = num;
            this.op = op;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }

    static String bfs() {
        if (s == t) return "0";

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(s, ""));
        boolean[] visited = new boolean[max + 1];
        visited[s] = true;
        boolean first = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int num = cur.num;
            String op = cur.op;

            if (num == t) {
                return op;
            }

            long tmp = (long)num * num; // 범위 조심
            if (tmp <= max && !visited[(int)tmp]) {
                q.offer(new Node((int)tmp, op + "*"));
                visited[(int)tmp] = true;
            }

            if (num + num <= max && !visited[num + num]) {
                q.offer(new Node(num + num, op + "+"));
                visited[num + num] = true;
            }

            if (first) {
                first = false;
                visited[0] = true;
                visited[1] = true;
                q.offer(new Node(0, op + "-"));
                q.offer(new Node(1, op + "/"));
            }
        } return "-1";
    }
}
