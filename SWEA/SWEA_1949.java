package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA 1949: 등산로 조성
 */

public class SWEA_1949 {
	static int N, K, longest;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 지도 한 변 길이
			K = Integer.parseInt(st.nextToken()); // 최대 공사 가능 깊이
			
			map = new int[N][N];
			visited = new boolean[N][N];
			longest = 0;
			
			int max = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == max) {
						visited[i][j] = true;
						dfs(i, j, 1, max, false);
						visited[i][j] = false;
					}
				}
			}
			
			System.out.println("#" + t + " " + longest);
		}
	}

	static void dfs(int x, int y, int length, int curHeight, boolean worked) {
		longest = Math.max(longest, length);
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if (visited[nx][ny]) continue;
			
			// 안 깎는 경우
			if (curHeight > map[nx][ny]) {
				visited[nx][ny] = true;
				dfs(nx, ny, length + 1, map[nx][ny], worked);
				visited[nx][ny] = false;
			}
			
			// 깎는 경우
			else if (!worked && curHeight > (map[nx][ny] - K)) {
				int origin = map[nx][ny];
				map[nx][ny] = curHeight - 1;
				visited[nx][ny] = true;
				dfs(nx, ny, length + 1, map[nx][ny], true);
				visited[nx][ny] = false;
				map[nx][ny] = origin;
			}
		}
	}
}