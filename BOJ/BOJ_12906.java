package BOJ;

/*
BOJ 12906: 새로운 하노이 탑
음... 어렵다
따라 쳤지만 이해가 안 가서 다시 풀어 봐야 할 문제
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_12906 {
    static HashSet<String> set;
    static Queue<Node> q;
    static String ans;

    static class Node {
        Stack<Character>[] tower;

        public Node() {
            this.tower = new Stack[3];

            for (int i = 0; i < 3; i++) {
                this.tower[i] = new Stack<>();
            }
        }

        public String statusCode() {
            StringBuilder sb = new StringBuilder();

            for (char c : this.tower[0]) sb.append(c);
            sb.append('/');
            for (char c : this.tower[1]) sb.append(c);
            sb.append('/');
            for (char c : this.tower[2]) sb.append(c);
            sb.append('/');

            return sb.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        set = new HashSet<>();
        q = new LinkedList<>();

        int a, b, c;
        a = b = c = 0;

        Node start = new Node();
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("0")) continue;

            for (char ch : st.nextToken().toCharArray()) {
                if (ch == 'A') a++;
                if (ch == 'B') b++;
                if (ch == 'C') c++;
                start.tower[i].push(ch);
            }
        }

        Node end = new Node();
        for (int i = 0; i < a; i++) end.tower[0].push('A');
        for (int i = 0; i < b; i++) end.tower[1].push('B');
        for (int i = 0; i < c; i++) end.tower[2].push('C');

        ans = end.statusCode();

        q.offer(start);
        set.add(start.statusCode());
        System.out.println(bfs());
    }

    static int bfs() {
        int t = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int k = 0; k < size; ++k) {
                Node cur = q.poll();

                if (cur.statusCode().equals(ans)) {
                    return t;
                }

                for (int i = 0; i < 3; ++i) {
                    for (int j = 0; j < 3; ++j) {
                        if (!cur.tower[i].isEmpty()) {
                            if (i == j) continue;

                            Node next = copy(cur);

                            next.tower[j].push(next.tower[i].pop());

                            String statusCode = next.statusCode();
                            if (!set.contains(statusCode)) {
                                set.add(statusCode);
                                q.offer(next);
                            }
                        }
                    }
                }
            }
            t++;
        }
        return t;
    }

    static Node copy(Node origin) {
        Node result = new Node();

        for (int i = 0; i < 3; ++i) {
            for (char ch : origin.tower[i]) result.tower[i].push(ch);
        }

        return result;
    }
}