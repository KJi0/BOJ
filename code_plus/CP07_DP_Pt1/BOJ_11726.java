package code_plus.CP07_DP_Pt1;

/*
 * BOJ 11726 : 2xn 타일링
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[1001];
		dp[1] = 1;
		dp[2] = 2;
		
		for (int i = 3; i <= N; i++) {
				dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		}
		
		System.out.print(dp[N]);
	}
}