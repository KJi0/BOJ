package code_plus.CP03_N과_M;

/*
 * BOJ 18290 : NM과 K (1)
 * 사실 넘 어려웠어요...
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18290 {
	public static int N, M, K, answer;
	public static boolean[][] visit;
	public static int[][] arr;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, -1, 0, 1};
	
	public static void solve(int x, int y, int count, int sum) {
			if (count == K) {
				answer = Math.max(answer, sum);
				return;
			}
			
			for (int i = x; i < N; i++) {
				for (int j = y; j < M; j++) {
					if (!visit[i][j]) {
						if (check(i, j)) {
							visit[i][j] = true;
							solve(x, y, count + 1, sum + arr[i][j]);
							visit[i][j] = false;
						}
					}
				}
			}
		}
	
	public static boolean check(int x, int y) {
		boolean flag = true;
		for (int i = 0; i < 4; i++) {
			int next_x = x + dx[i];
			int next_y = y + dy[i];
			
			if (next_x >= 0 && next_x < N && next_y >= 0 && next_y < M) {
				if (visit[next_x][next_y]) {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[N + 1][M + 1];
		answer = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve(0, 0, 0, 0);
		System.out.println(answer);
	}
}