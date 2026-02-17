package SWEA;

/*
 * SWEA 1861: 정사각형 방
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1861 {
	static int N, idx, max;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			idx = 0;
			max = Integer.MIN_VALUE;
			
			for (int startX = 0; startX < N; startX++) {
				for (int startY = 0; startY < N; startY++) {
					visited[startX][startY] = true;
					dfs(startX, startY, startX, startY, 1);
					visited[startX][startY] = false;
				}
			}
			
			System.out.println("#" + t + " " + idx + " " + max);
		}
	}
	
	static void dfs(int sx, int sy, int x, int y, int cnt) {
		if (cnt > max || (cnt == max && idx > map[sx][sy])) {
			max = cnt;
			idx = map[sx][sy];
		}
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if ((map[nx][ny] - map[x][y]) != 1 || visited[nx][ny]) continue;
			
			visited[nx][ny] = true;
			dfs(sx, sy, nx, ny, cnt + 1);
			visited[nx][ny] = false;
		}
	}
}
