package code_plus.CP05_순열;

/*
 * BOJ 10819 : 차이를 최대로
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10819 {
	static int N;
	static int[] arr, perm;
	static boolean[] visit;
	static int max = Integer.MIN_VALUE;
	
	public static void dfs (int depth) {
		if (depth == N) {
			int diff = 0;
			for (int i = 0; i < N - 1; i++) {
				diff += Math.abs(perm[i] - perm[i + 1]);
			}
			max = Math.max(max, diff);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				perm[depth] = arr[i];
				dfs(depth + 1);
				visit[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		visit = new boolean[N];
		perm = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0);
		
		System.out.println(max);
	}
}