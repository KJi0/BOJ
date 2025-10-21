package BOJ;

/*
BOJ 1932: 정수 삼각형
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] triangle = new int[N][N];
        int[][] dp = new int[N][N];

        triangle[0][0] = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = triangle[0][0];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0)
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];

                else if (j == i)
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];

                else
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < dp[N - 1][i])
                max = dp[N - 1][i];
        }

        System.out.println(max);
    }
}
