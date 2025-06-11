package 단기간_성장;

/*
 * BOJ 10942 : 팰린드롬?
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10942 {
	static int N;
	static boolean[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		int[] num = new int[N + 1];
		dp = new boolean[N + 1][N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		palindrome(num);
		
		int M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			if (dp[S][E]) sb.append("1\n");
			else sb.append("0\n");
		}
		
		System.out.println(sb);
	}

	public static void palindrome(int[] num) {
		for (int i = 1; i <= N; i++) {
			dp[i][i] = true;
		}
		
		for (int i = 1; i <= N - 1; i++)
			if (num[i] == num[i + 1]) dp[i][i + 1] = true;
		
		for (int i = 2; i < N; i++) {
			for (int j = 1; j <= N - i; j++) {
				if (num[j] == num[j + i] && dp[j + 1][j + i - 1])
					dp[j][j + i] = true;
			}
		}
	}
}
