package SWEA;

/*
SWEA 5644: 무선 충전
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_5644 {
    static int M, A;
    static int[][] user, map;
    static List<BC> bc;

    static int[] dx = {0, -1, 0, 1, 0};
    static int[] dy = {0, 0, 1, 0, -1};

    static class BC {
        int x; int y; int C; int P;

        public BC(int x, int y, int C, int P) {
            this.x = x;
            this.y = y;
            this.C = C;
            this.P = P;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());

            user = new int[2][M];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++)
                    user[i][j] = Integer.parseInt(st.nextToken());
            }

            bc = new ArrayList<>();
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken()) - 1;
                int x = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());

                bc.add(new BC(x, y, c, p));
            }

            int ans = simul();
            System.out.println("#" + t + " " + ans);
        }
    }

    static int simul() {
        int ax = 0, ay = 0;
        int bx = 9, by = 9;
        int total = 0;

        // 충전은 M + 1
        for (int t = 0; t <= M; t++) {
            total += getMaxCharge(ax, ay, bx, by);

            // 이동은 M
            if (t == M) break;

            ax += dx[user[0][t]];
            ay += dy[user[0][t]];

            bx += dx[user[1][t]];
            by += dy[user[1][t]];
        }

        return total;
    }

    static int getMaxCharge(int ax, int ay, int bx, int by) {
        int max = 0;

        for (int i = 0; i < A; i++) {
            for (int j = 0; j < A; j++) {
                int a = 0;
                int b = 0;

                BC bcA = bc.get(i);
                BC bcB = bc.get(j);

                if (Math.abs(ax - bcA.x) + Math.abs(ay - bcA.y) <= bcA.C) a = bcA.P;
                if (Math.abs(bx - bcB.x) + Math.abs(by - bcB.y) <= bcB.C) b = bcB.P;

                if (i == j) max = Math.max(max, Math.max(a, b));
                else max = Math.max(max, a + b);
            }
        }

        return max;
    }
}
