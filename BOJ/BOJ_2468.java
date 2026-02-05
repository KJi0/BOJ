package BOJ;

/*
 * BOJ 2468: 안전 영역
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2468 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		int maxHeight = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			
				if (map[i][j] > maxHeight) maxHeight = map[i][j];
			}
		}
		
		int maxSaveZone = Integer.MIN_VALUE;
		for (int h = 0; h < maxHeight; h++) {
			visited = new boolean[N][N];
			int saveZone = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j]) continue;
					
					if (map[i][j] > h)
						saveZone += isSaveZone(i, j, h);
				}
			}
			
			maxSaveZone = Math.max(maxSaveZone, saveZone);
		}
		
		System.out.println(maxSaveZone);
	}
	
	static int isSaveZone(int x, int y, int h) {
		visited[x][y] = true;
	
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if (visited[nx][ny]) continue;
			
			if (map[nx][ny] > h) isSaveZone(nx, ny, h);
		}
		
		return 1;
	}
}
