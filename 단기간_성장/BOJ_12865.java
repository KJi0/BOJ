package 단기간_성장;

/*
 * BOJ 12865 : 평범한 배낭
 * 그 유명한 knapsack 문제
 * 처음에 이해를 좀 헤맸다... 복습 필요!!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] W = new int[N + 1];
		int[] V = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N + 1][K + 1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if (j >= W[i]) {
					dp[i][j] = Math.max(dp[i - 1][j], V[i] + dp[i - 1][j - W[i]]);
				} else
					dp[i][j] = dp[i - 1][j];
			}
		}
		
		System.out.println(dp[N][K]);
	}
}
