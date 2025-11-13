package BOJ;

/*
BOJ 12886: 돌 그룹
연산을 아무리 반복해도 A + B + C = N은 일정하며,
세 그룹이 모두 같아지려면 A = B = C = N / 3이 되어야 한다.
고로 N은 무조건 3의 배수이다.
즉, 세 그룹이 모두 같아지려면 A + B + C는 3의 배수여야 한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12886 {
    static int A, B, C;

    static class Stone {
        int A;
        int B;
        int C;
        public Stone(int A, int B, int C) {
            this.A = A;
            this.B = B;
            this.C = C;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(bfs() ? 1 : 0);
    }

    static boolean bfs() {
        if ((A + B + C) % 3 != 0) return false;

        Queue<Stone> q = new LinkedList<>();
        q.offer(new Stone(A, B, C));
        boolean[][] visited = new boolean[1501][1501];
        visited[A][B] = true;

        while (!q.isEmpty()) {
            Stone cur = q.poll();
            int A = cur.A;
            int B = cur.B;
            int C = cur.C;

            if (A == B && B == C) {
                return true;
            }

            if (A != B) {
                int na = A > B ? A - B : A + A;
                int nb = A > B ? B + B : B - A;

                if (!visited[na][nb]) {
                    q.offer(new Stone(na, nb, C));
                    visited[na][nb] = true;
                }
            }

            if (B != C) {
                int nb = B > C ? B - C : B + B;
                int nc = B > C ? C + C : C - B;

                if (!visited[nb][nc]) {
                    q.offer(new Stone(A, nb, nc));
                    visited[nb][nc] = true;
                }
            }

            if (A != C) {
                int na = A > C ? A - C : A + A;
                int nc = A > C ? C + C : C - A;

                if (!visited[na][nc]) {
                    q.offer(new Stone(na, B, nc));
                    visited[na][nc] = true;
                }
            }
        } return false;
    }
}
