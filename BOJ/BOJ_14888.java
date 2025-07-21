package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888 {
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] A, op;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        op = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(A[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int num, int idx) {
        if (idx == N) {
            max = Math.max(num, max);
            min = Math.min(num, min);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;

                switch (i) {
                    case 0: dfs(num + A[idx], idx + 1); break;
                    case 1: dfs(num - A[idx], idx + 1); break;
                    case 2: dfs(num * A[idx], idx + 1); break;
                    case 3: dfs(num / A[idx], idx + 1); break;
                }

                op[i]++;
            }
        }
    }
}