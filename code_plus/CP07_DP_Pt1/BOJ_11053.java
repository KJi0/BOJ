package code_plus.CP07_DP_Pt1;

/*
 * BOJ 11053 : 가장 긴 증가하는 부분 수열
 * 이해가 안 가서 애먹음...
 * 사실 아직 이해를 완전히 못했다 ㅠ
 * 복습 꼭 필요...!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11053 {
	static int N;
	static int[] A;
	static Integer[] dp;
	
	public static int recur(int N) {
		
		if (dp[N] == null) {
			dp[N] = 1;
		
			for (int i = N - 1; i >= 0; i--) {
				if (A[i] < A[N]) {
					dp[N] = Math.max(dp[N], recur(i) + 1);
				}
			}
		}
		return dp[N];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N]; 
		dp = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			recur(i);
		}
		
		int max = dp[0];
		
		for (int i = 1; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
}