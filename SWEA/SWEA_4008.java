package SWEA;

/*
 * SWEA 4008: 숫자 만들기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4008 {
	static int N, min, max;
	static int[] num, op;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			min = Integer.MAX_VALUE; max = Integer.MIN_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			op = new int[4];
			for (int i = 0; i < 4; i++) op[i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			num = new int[N];
			for (int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
			
			dfs(1, num[0]);
			System.out.println("#" + t + " " + (max - min));
		}
	}

	static void dfs(int depth, int sum) {
		if (depth == N) {
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (op[i] > 0) {
				op[i]--;
				
				switch (i) {
				case 0:
					dfs(depth + 1, sum + num[depth]);
					break;
				case 1:
					dfs(depth + 1, sum - num[depth]);
					break;
				case 2:
					dfs(depth + 1, sum * num[depth]);
					break;
				case 3:
					dfs(depth + 1, sum / num[depth]);
					break;
				}
				
				op[i]++;
			}
		}
	}
}