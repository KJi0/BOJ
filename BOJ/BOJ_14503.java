package BOJ;

/*
 * BOJ 14503: 로봇 청소기
 * 방향 설정이 느무 헷갈리넴...
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503 {
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	static int Y, X, cnt = 1;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new int[Y][X];
		
		st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < X; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		robot(r, c, d);
		System.out.println(cnt);
	}

	public static void robot(int r, int c, int dir) {
		map[r][c] = -1;
		
		for (int i = 0; i < 4; i++) {
			dir = (dir + 3) % 4;
			
			int ny = r + dy[dir];
			int nx = c + dx[dir];
			
			if (nx >= 0 && nx < X && ny >= 0 && ny < Y) {
				if (map[ny][nx] == 0) {
					cnt++;
					robot(ny, nx, dir);
					return; // 현재 위치 더 탐색할 필요 없음
				}
			}
		}
		
		int bdir = (dir + 2) % 4;
		int by = r + dy[bdir];
		int bx = c + dx[bdir];
		
		if (bx >= 0 && bx < X && by >= 0 && by < Y) {
			if (map[by][bx] != 1)
				robot(by, bx, dir); // 후진이니까 바라보는 방향은 유지!
		}
	}
}
