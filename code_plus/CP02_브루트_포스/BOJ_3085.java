package code_plus.CP02_브루트_포스;

/*
 * BOJ 3085 : 사탕 게임
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3085 {
	
	static char[][] arr;
	static int N;
	static int max = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++)
				arr[i][j] = s.charAt(j);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0 ; j < N - 1; j++) {
				swap(i, j, i, j + 1);
				search();
				swap(i, j + 1, i, j);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				swap(j, i, j + 1, i);
				search();
				swap(j + 1, i, j, i);
			}
		}
		
		System.out.print(max);
	}

	public static void swap(int x1, int y1, int x2, int y2) {
		char temp = arr[x1][y1];
		arr[x1][y1] = arr[x2][y2];
		arr[x2][y2] = temp;
	}
	
	public static void search() {
		// 행 기준 탐색
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			
			for (int j = 0; j < N - 1; j++) {
				if (arr[i][j] == arr[i][j + 1]) {
					cnt++;
					max = Math.max(cnt, max);
				}
				else
					cnt = 1;
			}
		}
		// 열 기준 탐색
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			
			for (int j = 0; j < N - 1; j++) {
				if (arr[j][i] == arr[j + 1][i]) {
					cnt++;
					max = Math.max(cnt, max);
				}
				else
					cnt = 1;
			}
		}
	}
}