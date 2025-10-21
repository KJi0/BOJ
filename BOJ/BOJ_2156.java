package BOJ;

/*
BOJ 2156: 포도주 시식
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156 {
    static int N;
    static int[] wine;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        wine = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++)
            wine[i] = Integer.parseInt(br.readLine());

        // 이거 안 하니까 틀렸다
        if (N == 1) {
            System.out.println(wine[1]);
            return;
        }

        dp[1] = wine[1];
        dp[2] = wine[1] + wine[2];

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
        }

        System.out.println(dp[N]);
    }
}