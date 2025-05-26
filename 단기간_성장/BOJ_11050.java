package 단기간_성장;

/*
 * BOJ 11050 : 이항 계수 1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11050 {
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		dp = new int[N + 1][K + 1];
		System.out.println(binomial(N, K));
	}

	public static int binomial(int N, int K) {
		if (K == 0 || N == K) return 1;
		
		if (dp[N][K] == 0)
			dp[N][K] = binomial(N - 1, K - 1) + binomial(N - 1, K);
		
		return dp[N][K];
	}
}
