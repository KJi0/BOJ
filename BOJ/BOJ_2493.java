package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {
    /*
     * BOJ 2493: 탑
     */

    static class Node {
        int idx;
        int height;

        public Node(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Node> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            while (!s.isEmpty()) {
                if (s.peek().height >= arr[i]) {
                    sb.append(s.peek().idx).append(" ");
                    break;
                } s.pop();
            }

            if (s.isEmpty()) {
                sb.append("0 ");
            }

            s.push(new Node(i, arr[i]));
        }

        System.out.println(sb);
    }
}