package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * SWEA 1949: 등산로 조성
 */

public class SWEA_1949 {
	static int N, K, longest;
	static int[][] map;
	static ArrayList<int[]> tallest;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 지도 한 변 길이
			K = Integer.parseInt(st.nextToken()); // 최대 공사 가능 깊이
			
			tallest = new ArrayList<>();
			longest = Integer.MIN_VALUE;
			
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					//tallest = Math.max(tallest, map[i][j]);
				}
			}
			
			
		}
	}

	static void dfs(int depth, int length) {
		if (depth == K) {
			longest = Math.max(longest, length);
			return;
		}
		
		
	}
}