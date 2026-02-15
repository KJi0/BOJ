package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_7206 {
	static int[] dp = new int[1_000_001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		Arrays.fill(dp, -1);
		
		for (int t = 1; t <= T; t++) {
			int start = Integer.parseInt(br.readLine());
			
			int ans = dfs(start);
			System.out.println("#" + t + " " + ans);
		}
	}
	
	static int dfs(int n) {
		if (n < 10) return 0;
		if (dp[n] != -1) return dp[n];
		
		String s = String.valueOf(n);
		int max = 0;
		
		for (int i = 1; i < s.length(); i++) {
			long first = Long.parseLong(s.substring(0, i));
			max = Math.max(max, 1 + split(s, i, first));
		}

		dp[n] = max;
		return max;
	}
	
	static int split(String s, int idx, long item) {
		if (idx == s.length()) return dfs((int) item);
		
		long num = 0;
		int max = 0;
		
		for (int i = idx; i < s.length(); i++) {
			num = num * 10 + (s.charAt(i) - '0');
			max = Math.max(max, split(s, i + 1, item * num));
		}

		return max;
	}
}