package SWEA;

/*
 * SWEA 1486: 장훈이의 높은 선반
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1486 {
	static int N, B, diff;
	static int[] H;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 점원 수
			B = Integer.parseInt(st.nextToken()); // 탑의 높이 > B
			
			H = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) H[i] = Integer.parseInt(st.nextToken());
			
			diff = Integer.MAX_VALUE;
			dfs(0, 0);
			System.out.println("#" + t + " " + diff);
		}
	}

	static void dfs(int idx, int h) {
		if (idx == N) {
			if (h < B) return;
			diff = Math.min(diff, h - B);
			return;
		}
		
		dfs(idx + 1, h + H[idx]);
		dfs(idx + 1, h);
	}
}