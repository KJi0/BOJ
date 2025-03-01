package code_plus.CP07_DP_Pt1;

/*
 * BOJ 10844 : 쉬운 계단 수
 * 안 쉬운 계단 수 ㅋ...
 * 자연수의 자릿수는 오른쪽에서 왼쪽으로 갈수록 자릿수가 증가!
 * 소수와 반대!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10844 {
	
	final static long mod = 1_000_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[][] dp = new long[N + 1][10];
		
		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				
				if (j == 0) {
					dp[i][0] = dp[i - 1][1] % mod;
				}
				
				else if (j == 9) {
					dp[i][9] = dp[i - 1][8] % mod;
				}
				
				else {
					dp[i][j] = (dp[i - 1][j + 1] + dp[i - 1][j - 1]) % mod;
				}
			}
		}
		
		long ans = 0;
		
		for (int i = 0; i < 10; i++) {
			ans += dp[N][i];
		}
		
		System.out.println(ans % mod);
	}
}