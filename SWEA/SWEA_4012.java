package SWEA;

/*
 * SWEA 4012: 요리사
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4012 {
	static int N, min;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			min = Integer.MAX_VALUE;
			dfs(0, 0);
			System.out.println("#" + t + " " + min);
		}
	}

	static void dfs(int cnt, int start) {
		if (cnt == N / 2) {
			int diff = calculate();
			min = Math.min(min, diff);
			return;
		}
		
		for (int i = start; i < N; i++) {
			visited[i] = true;
			dfs(cnt + 1, i + 1);
			visited[i] = false;
		}
	}
	
	static int calculate () {
		int aSum = 0; int bSum = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				
				if (visited[i] && visited[j]) {
					aSum += map[i][j];
					aSum += map[j][i];
				}
				
				else if (!visited[i] && !visited[j]) {
					bSum += map[i][j];
					bSum += map[j][i];
				}
			}
		}
		
		return Math.abs(aSum - bSum);
	}
}
