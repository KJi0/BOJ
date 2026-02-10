package SWEA;

/*
 * SWEA 2806: N-Queen
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2806 {
	static int N, totalCnt;
	static int[] queen;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			totalCnt = 0;
		
			queen = new int[N];			
			
			dfs(0);
			System.out.println("#" + t + " " + totalCnt);
		}
	}

	static void dfs(int row) {
		if (row == N) {
			totalCnt++;
			return;
		}
		
		for (int c = 0; c < N; c++) {
			queen[row] = c;
			if (isOk(row)) {
				dfs(row + 1);
			}
		}
	}
	
	static boolean isOk(int row) {
		for (int i = 0; i < row; i++) {
			if (queen[i] == queen[row] || ((row - i) == Math.abs(queen[row] - queen[i])))
				return false;
		}
		return true;
	}
}
