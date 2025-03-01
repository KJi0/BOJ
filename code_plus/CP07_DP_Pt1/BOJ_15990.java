package code_plus.CP07_DP_Pt1;

/*
 * BOJ 15990 : 1, 2, 3 더하기 5
 * 어려움...
 * 그치만 전형적인 2차원 dp 문제라고 하니
 * 잘 숙지해 두자
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15990 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		long[][] dp = new long[100001][4];
		
		dp[1][1] = 1; // 1
		dp[2][2] = 1; // 2
		dp[3][1] = 1; // 2 + 1
		dp[3][2] = 1; // 1 + 2
		dp[3][3] = 1; // 3
		
		for (int i = 4; i <= 100000; i++) {
			dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % 1_000_000_009;
			dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % 1_000_000_009;
			dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % 1_000_000_009;
		}
		
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			sb.append((dp[N][1] + dp[N][2] + dp[N][3]) % 1_000_000_009).append("\n");
		} 
		
		System.out.println(sb);
	}
}