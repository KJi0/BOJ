package code_plus.CP05_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10971 {
	static int N;
	static int[][] W;
	static boolean[] visit;
	static int min = Integer.MAX_VALUE;
	
	public static void dfs(int start, int now, int cnt, int sum) {
		if (cnt == N && W[now][start] != 0) {
			sum += W[now][start];
			min = Math.min(min, sum);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visit[i] && W[now][i] > 0) {
				visit[i] = true;
				dfs(start, i, cnt + 1, sum + W[now][i]);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		visit = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++)
				W[i][j] = Integer.parseInt(st.nextToken());
		}
		
		visit[0] = true;
		dfs(0, 0, 1, 0);
		
		System.out.println(min);
	}
}