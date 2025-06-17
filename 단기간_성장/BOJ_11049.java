package 단기간_성장;

/*
 * BOJ 11049 : 행렬 곱셈 순서
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11049 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][N];
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N][N];
		
		for (int k = 1; k < N; k++) {
			for (int i = 0; i + k < N; i++) {
				dp[i][i + k] = Integer.MAX_VALUE;
				for (int j = i; j < i + k; j++) {
					dp[i][i + k] = Math.min(dp[i][i + k],
							dp[i][j] + dp[j + 1][i + k] + arr[i][0] * arr[j][1] * arr[i + k][1]);
				}
			}
		}	
		System.out.println(dp[0][N - 1]);
	}
}