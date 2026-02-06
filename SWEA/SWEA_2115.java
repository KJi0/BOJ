package SWEA;

/*
 * SWEA 2115: 벌꿀채취
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2115 {
	static int N, M, C, max, maxProfit;
	static int[] tmp;
	static int[][] map, profit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 벌통 크기
			M = Integer.parseInt(st.nextToken()); // 선택할 수 있는 벌통 수
			C = Integer.parseInt(st.nextToken()); // 채취 가능한 최대 꿀의 양
			
			map = new int[N][N];
			profit = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) 
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			// 일꾼1
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N - M; j++) {
					tmp = new int[M];
					for (int k = 0; k < M; k++) { 
						tmp[k] = map[i][j + k]; 
					}
	
					maxProfit = 0;
					subset(0, 0, 0);
					profit[i][j] = maxProfit;
				}
			}
			
			// 일꾼1 + 일꾼2
			max = 0;
			for (int i1 = 0; i1 < N; i1++) {
				for (int j1 = 0; j1 <= N - M; j1++) {
					for (int i2 = 0; i2 != i1 && i2 < N; i2++) {
						for (int j2 = 0; j2 <= N - M; j2++) {
							max = Math.max(max, profit[i1][j1] + profit[i2][j2]);
						}
					}
				}
			}
			
			System.out.println("#" + t + " " + max);
		}
	}

	static void subset(int idx, int honeySum, int profitSum) {
		if (honeySum > C) return;
		
		if (idx == M) {
			maxProfit = Math.max(maxProfit, profitSum);
			return;
		}
		
		subset(idx + 1, honeySum + tmp[idx], profitSum + tmp[idx] * tmp[idx]);
		subset(idx + 1, honeySum, profitSum);
	}
}
