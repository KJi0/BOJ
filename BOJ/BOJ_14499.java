package BOJ;

/*
 * BOJ 14499: 주사위 굴리기
 * 아... 어려웠다
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14499 {
	static int N, M, x, y, K;
	static int[][] map;
	static int[] dice;
	// 동 서 남 북
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dice = new int[6];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int order = Integer.parseInt(st.nextToken());
			roll(order - 1);
		}
		
		System.out.println(sb);
	}
	
	public static void roll(int dir) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		
		if (nx < 0 || nx >= N || ny < 0 || ny >= M)
			return;
		
		int tmp = dice[5];
		
		switch(dir) {
		case 0: // 동
			dice[5] = dice[2];
			dice[2] = dice[0];
			dice[0] = dice[3];
			dice[3] = tmp;
			break;
		case 1: // 서
			dice[5] = dice[3];
			dice[3] = dice[0];
			dice[0] = dice[2];
			dice[2] = tmp;
			break;
		case 2: // 남
			dice[5] = dice[4];
			dice[4] = dice[0];
			dice[0] = dice[1];
			dice[1] = tmp;
			break;
		default: // 북
			dice[5] = dice[1];
			dice[1] = dice[0];
			dice[0] = dice[4];
			dice[4] = tmp;
		}
		
		x = nx;
		y = ny;
		
		if (map[x][y] == 0) map[x][y] = dice[5];
		else {
			dice[5] = map[x][y];
			map[x][y] = 0;
		}
		
		sb.append(dice[0]).append('\n');
	}
}