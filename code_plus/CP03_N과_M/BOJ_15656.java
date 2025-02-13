package code_plus.CP03_N과_M;

/*
 * BOJ 15656 : N과 M (7)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ_15656 {
	public static int N;
	public static int M;
	public static int X[];
	public static int arr[];
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = new int[N];
		arr = new int[M];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++)
			X[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(X);
		
		dfs(0, 0);
		System.out.println(sb);
	}

	public static void dfs(int depth, int start) {
		if (depth == M) {
			for (int val : arr) {
				sb.append(val).append(' ');
				}
			sb.append('\n');
			return;
		}
		
		for (int i = start; i < N; i++) {
			arr[depth] = X[i];
			dfs(depth + 1, i);
		}
	}
}