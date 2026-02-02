package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1226 {
	/*
	 * SWEA 1226: 미로1
	 */
	
	static int N;
	static int startX = 0; static int startY = 0;
	static int endX = 0; static int endY = 0;
	static char[][] map;
	static boolean flag;
	static boolean[][] visited;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			br.readLine();
			
			map = new char[16][16];
			for (int i = 0; i < 16; i++) {
				map[i] = br.readLine().toCharArray();
					
				for (int j = 0; j < 16; j++) {
					if (map[i][j] == '2') { startX = i; startY = j; }
					if (map[i][j] == '3') { endX = i; endY = j; }
				}
			}
			
			visited = new boolean[16][16];
			visited[startX][startY] = true;
			
			flag = false;
			dfs(startX, startY);
			System.out.println("#" + t + " " + (flag ? 1 : 0));	
		}
	}
	
	static void dfs(int x, int y) {
		if (flag) return;
		
		if (x == endX && y == endY) {
			flag = true;
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (nx < 0 || nx >= 16 || ny < 0 || ny >= 16) continue;
			if (map[nx][ny] == '1' || visited[nx][ny]) continue;
			
			visited[nx][ny] = true;
			dfs(nx, ny);
		}
	}
}