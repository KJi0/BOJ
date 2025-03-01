package 단계별로_풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2193 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[91][2];
		
		dp[1][1] = 1; // 1
		dp[2][0] = 1; // 10
		dp[3][1] = 1; // 101
		dp[3][0] = 1; // 100
		
		for (int i = 4; i <= N; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
			dp[i][1] = dp[i - 1][0];
		}
		
		System.out.println(dp[N][0] + dp[N][1]);
	}
}