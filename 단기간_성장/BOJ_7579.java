package 단기간_성장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7579 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[N][100001];
		int[] c = new int[N];
		int[] m = new int[N];
		int ans = Integer.MAX_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			m[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			c[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 100001; j++) {
				if (i == 0) {
					if (j >= c[i]) dp[i][j] = m[i];
				}
				
				else { 
					if (j >= c[i])
						dp[i][j] = Math.max(dp[i - 1][j],
								m[i] + dp[i - 1][j - c[i]]);
					else
						dp[i][j] = dp[i - 1][j];
				}
				
				if (dp[i][j] >= M)
					ans = Math.min(ans, j);
			}
		}
		
		System.out.println(ans);
	}

}
