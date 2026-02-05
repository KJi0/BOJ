package SWEA;

/*
 * SWEA 4130: 특이한 자석
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4130 {
	static int K;
	static int[] dir;
	static int[][] magnet = new int[4][8];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			K = Integer.parseInt(br.readLine());
			
			StringTokenizer st;
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) 
					magnet[i][j] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				dir = new int[4];
				
				int n = Integer.parseInt(st.nextToken()) - 1;
				int d = Integer.parseInt(st.nextToken());
				
				dir[n] = d;
				check(n);
				rotate();
			}
			
			System.out.println("#" + t + " " + getScore());
		}
	}
	
	static void check(int num) {
		for (int i = num - 1; i >= 0; i--) {
			if (magnet[i][2] == magnet[i + 1][6]) break;
			else dir[i] = -dir[i + 1];
		}
		
		for (int i = num + 1; i < 4; i++) {
			if (magnet[i - 1][2] == magnet[i][6]) break;
			else dir[i] = -dir[i - 1];
		}
	}
	
	static void rotate() {
		for (int i = 0; i < 4; i++) {
			
			if (dir[i] == 1) {
				int tmp = magnet[i][7];
				for (int j = 7; j > 0; j--) magnet[i][j] = magnet[i][j - 1];
				magnet[i][0] = tmp;
			}
			
			if (dir[i] == -1) {
				int tmp = magnet[i][0];
				for (int j = 0; j < 7; j++) magnet[i][j] = magnet[i][j + 1];
				magnet[i][7] = tmp;
			}
		}
	}
	
	static int getScore() {
		int totalScore = 0;
		int value = 1;
		
		for (int i = 0; i < 4; i++) {
			totalScore += (magnet[i][0] == 0) ? 0 : value;
			value *= 2;
		}
		
		return totalScore;
	}
}
