package SWEA;

/*
SWEA 8275: 햄스터
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_8275 {
    static int N, X, M, max;
    static int[] cage, ans;
    static int[][] condition;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            cage = new int[N];
            ans = new int[N];
            condition = new int[M][3];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                condition[i][0] = Integer.parseInt(st.nextToken()) - 1;
                condition[i][1] = Integer.parseInt(st.nextToken()) - 1;
                condition[i][2] = Integer.parseInt(st.nextToken());
            }

            max = -1;
            dfs(0);

            System.out.print("#" + t + " ");
            if (max == -1) System.out.println(max);
            else {
                for (int n : ans) System.out.print(n + " ");
                System.out.println();
            }
        }
    }

    static void dfs(int depth) {
        if (depth == N) {
            if (isOk()) {
                int sum = 0;
                for (int i = 0; i < N; i++) sum += cage[i];

                if (sum > max) {
                    max = sum;
                    ans = Arrays.copyOf(cage, N);
                }
            }
            return;
        }

        for (int i = 0; i <= X; i++) {
            cage[depth] = i;
            dfs(depth + 1);
        }
    }

    static boolean isOk() {
        for (int i = 0; i < M; i++) {
            int sum = 0;
            for (int j = condition[i][0]; j <= condition[i][1]; j++)
                sum += cage[j];

            if (sum != condition[i][2]) return false;
        }
        return true;
    }
}
