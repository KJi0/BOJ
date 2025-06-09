package 단기간_성장;

/*
 * BOJ 11066 : 파일 합치기
 * 이해하는 데 너무 오래 걸렸다... 또륵
 * 공부 열심히 하자
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11066 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int K = Integer.parseInt(br.readLine());
			int[] file = new int[K + 1];
			int[][] dp = new int[K + 1][K + 1];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	
			for (int j = 1; j <= K; j++) {
				file[j] = file[j - 1] + Integer.parseInt(st.nextToken());
			}
			
			for (int j = 1; j <= K; j++) {
				for (int start = 1; start + j <= K; start++) {
					int end = start + j;
					dp[start][end] = Integer.MAX_VALUE;
					
					for (int mid = start; mid < end; mid++)
					dp[start][end] = Math.min(dp[start][end],
							dp[start][mid] + dp[mid + 1][end] + file[end] - file[start - 1]);
				}
			}
			
			System.out.println(dp[1][K]);
		}
	}
}
