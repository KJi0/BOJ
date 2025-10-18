package BOJ;

/*
BOJ 1149: RGB거리
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149 {
    static int R = 0;
    static int G = 1;
    static int B = 2;

    static int[][] cost;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        cost = new int[N][3];
        dp = new int[N][3];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            cost[i][R] = Integer.parseInt(st.nextToken());
            cost[i][G] = Integer.parseInt(st.nextToken());
            cost[i][B] = Integer.parseInt(st.nextToken());
        }

        dp[0][R] = cost[0][R];
        dp[0][G] = cost[0][G];
        dp[0][B] = cost[0][B];

        int ans = Math.min(paint(N - 1, R), Math.min(paint(N - 1, G), paint(N - 1, B)));
        System.out.println(ans);
    }

    static int paint(int n, int color) {
        if (dp[n][color] == 0) {

            if (color == R) {
                dp[n][R] = Math.min(paint(n - 1, G), paint(n - 1, B)) + cost[n][R];
            } else if (color == G) {
                dp[n][G] = Math.min(paint(n - 1, R), paint(n - 1, B)) + cost[n][G];
            } else {
                dp[n][B] = Math.min(paint(n - 1, R), paint(n - 1, G)) + cost[n][B];
            }
        }

        return dp[n][color];
    }
}