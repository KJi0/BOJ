package code_plus.CP05_순열;

/*
 * BOJ 6603 : 로또
 * 내 힘으로 금방 풀었음 ㅎㅎ 뿌듯!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603 {
	static int k;
	static int[] S, arr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();

	public static void dfs(int start, int depth) {
		if (depth == 6) {
			for (int val : arr) {
				sb.append(val).append(" ");
			} sb.append("\n");
			return;
		}
		
		for (int i = start; i < k; i++) {
			arr[depth] = S[i];
			dfs(i + 1, depth + 1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		
		while (!(str = br.readLine()).equals("0")) {
			StringTokenizer st = new StringTokenizer(str, " ");
			
			k = Integer.parseInt(st.nextToken());
			S = new int[k];
			arr = new int[6];
			visit = new boolean[k];
			
			for (int i = 0; i < k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}