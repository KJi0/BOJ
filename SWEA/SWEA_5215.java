package SWEA;

/*
 * SWEA 5215: 햄버거 다이어트
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215 {
	
	static int N, L, favorite, kcalSum, scoreSum;
	static int[] scores, kcals;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			favorite = kcalSum = scoreSum = 0;
			
			scores = new int[N];
			kcals = new int[N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int score = Integer.parseInt(st.nextToken());
				int kcal = Integer.parseInt(st.nextToken());
				
				scores[i] = score; kcals[i] = kcal;
			}
			
			dfs(0, 0, 0);
			System.out.println("#" + t + " " + favorite);
		}
	}

	static void dfs(int idx, int kcalSum, int scoreSum) {
		if (kcalSum > L) return;
		
		favorite = Math.max(favorite, scoreSum);
		
		if (idx == N) return;
		
		dfs(idx + 1, kcalSum + kcals[idx], scoreSum + scores[idx]);
		dfs(idx + 1, kcalSum, scoreSum);
	}
}

	/*
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int[] dp = new int[L + 1]; // dp[kc] = 칼로리 kc에서의 가장 높은 점수
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int score = Integer.parseInt(st.nextToken());
				int kcal = Integer.parseInt(st.nextToken());
				
				for (int kc = L; kc >= kcal; kc--) {
					dp[kc] = Math.max(dp[kc], dp[kc - kcal] + score);
				}
			}
			
			int favorite = 0;
			for (int kc = 0; kc <= L; kc++) favorite = Math.max(favorite, dp[kc]);
			
			System.out.println(favorite);
		}
	}
	*/
