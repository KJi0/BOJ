package 단기간_성장;

/*
 * BOJ 10830 : 행렬 제곱
 * 어렵도다...
 * 그래도 곱셈 문제로 pow 알고리즘에 대해 알아둬서
 * 아주 조금은 더 수월했던...!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10830 {
	static int N;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++)
				arr[i][j] = Integer.parseInt(st.nextToken()) % 1000;
		}
		
		int[][] answer = pow(arr, B);
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(answer[i][j]).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static int[][] pow(int[][] A, long exp) {
		if (exp == 1) return A;
		
		int[][] tmp = pow(A, exp / 2);
		
		tmp = multiply(tmp, tmp);
		
		if (exp % 2 == 1)
			return multiply(tmp, A);
			
		return tmp;
	}
	
	public static int[][] multiply(int[][] a1, int[][] a2) {
		int[][] tmp = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					tmp[i][j] += a1[i][k] * a2[k][j];
					tmp[i][j] %= 1000;
				}
			}
		}
		
		return tmp;
	}
}
