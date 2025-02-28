package code_plus.CP07_DP_Pt1;

/*
 * BOJ 16194 : 카드 구매하기 2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16194 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] P = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[1001];
		
		for (int i = 1; i <= N; i++) {
			dp[i] = P[i];
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j] + P[j]);
			}
		}
		
		System.out.println(dp[N]);
	}
}