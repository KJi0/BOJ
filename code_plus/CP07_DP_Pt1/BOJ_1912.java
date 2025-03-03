package code_plus.CP07_DP_Pt1;

/*
 * BOJ 1912 : 연속합
 */

import java.io.BufferedReader;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1912 {
	static int N, max;
	static int[] S;
	static Integer[] dp;

	public static int recur(int N) {
		if (dp[N] == null) {	
			dp[N] = Math.max(S[N], recur(N - 1) + S[N]);
			
			max = Math.max(max, dp[N]);
		}
		
		return dp[N];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N];
		dp = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = S[0];
		max = dp[0];
		
		recur(N - 1);
		
		System.out.println(max);
	}
}