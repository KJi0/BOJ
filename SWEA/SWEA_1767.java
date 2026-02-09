package SWEA;

/*
 * SWEA 1767: 프로세서 연결하기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1767 {
	static int N, maxCore, minLen;
	static int[][] map;
	static ArrayList<int[]> core;
	static StringBuilder sb = new StringBuilder();
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			core = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				
					if (map[i][j] == 1) {
						if (i == 0 || i == N - 1 || j == 0 || j == N - 1) continue;
						core.add(new int[] {i, j});
					}
				}
			}
			
			maxCore = 0;
			minLen = Integer.MAX_VALUE;
			
			dfs(0, 0, 0);
			sb.append("#").append(t).append(" ").append(minLen).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int idx, int coreCnt, int length) {
		if (idx == core.size()) {
			if (coreCnt > maxCore) {
				maxCore = coreCnt;
				minLen = length;
			}
			else if (coreCnt == maxCore) {
				minLen = Math.min(minLen, length);
			}
			return;
		}
		
		if (coreCnt + (core.size() - idx) < maxCore) return;
		
		int x = core.get(idx)[0];
		int y = core.get(idx)[1];
		
		for (int d = 0; d < 4; d++) {
			int len = canConnect(x, y, d);
			if (len == -1) continue;
			
			doConnect(x, y, d, 2);
			dfs(idx + 1, coreCnt + 1, length + len);
			doConnect(x, y, d, 0);
		}
		
		dfs(idx + 1, coreCnt, length);
	}
	
	static int canConnect(int x, int y, int d) {
		int nx = x;
		int ny = y;
		
		int len = 0;
		
		while (true) {
			nx += dx[d];
			ny += dy[d];
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) return len;
			if (map[nx][ny] != 0) return -1;
		
			len++;
		}
	}
	
	static void doConnect(int x, int y, int d, int val) {
		int nx = x;
		int ny = y;
		
		while (true) {
			nx += dx[d];
			ny += dy[d];
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;
		
			map[nx][ny] = val;
		}
	}
}
