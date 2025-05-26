package 단기간_성장;

/*
 * BOJ 11051 : 이항 계수 2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11051 {
	static long MOD = 10_007;
	static long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		dp = new long[N + 1][K + 1];
		System.out.println(binomial(N, K) % MOD);
	}

	public static long binomial(int N, int K) {
		if (K == 0 || N == K) return 1L;
		
		if (dp[N][K] == 0)
			dp[N][K] = binomial(N - 1, K - 1) + binomial(N - 1, K);
		
		return dp[N][K] % MOD;
	}
}