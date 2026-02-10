package SWEA;

/*
 * SWEA 1952: 수영장
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1952 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int[] price = new int[4];
			int[] plan = new int[13];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) price[i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) plan[i] = Integer.parseInt(st.nextToken());
			
			int[] dp = new int[13];
			dp[0] = 0;
			
			for (int i = 1; i <= 12; i++) {
				dp[i] = dp[i - 1] + (plan[i] * price[0]);
				dp[i] = Math.min(dp[i], dp[i - 1] + price[1]);
				if (i >= 3) {
					dp[i] = Math.min(dp[i], dp[i - 3] + price[2]);
				}
			}
			
			dp[12] = Math.min(dp[12], price[3]);
			System.out.println("#" + t + " " + dp[12]);
		}
	}
}
