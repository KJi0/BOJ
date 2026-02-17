package SWEA;

/*
 * SWEA 2117: 홍 방범 서비스
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2117 {
	static int N, M, ans;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			ans = Integer.MIN_VALUE;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					for (int K = 1; K <= N + 1; K++) {
						int houseCnt = getHouseCnt(i, j, K);
						
						int cost = K * K + (K - 1) * (K - 1);
						int profit = houseCnt * M - cost;
						
						if (profit >= 0) {
							ans = Math.max(ans, houseCnt);
						}
					}
				}
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
	
	static int getHouseCnt(int x, int y, int K) {
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				if (map[i][j] == 0) continue;
				int dist = Math.abs(x - i) + Math.abs(y - j);
				
				if (dist < K) cnt++;
			}
		}
		return cnt;
	}
}
