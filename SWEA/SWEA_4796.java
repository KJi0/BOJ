package SWEA;

/*
 * SWEA 4796: 의석이의 우뚝 선 산
 */

import java.util.Scanner;

public class SWEA_4796 {
	static int N;
	static int[] h;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			h = new int[N];
			
			for (int i = 0; i < N; i++) h[i] = sc.nextInt();
			
			int up = 0;
			int down = 0;
			int cnt = 0;
			
			for (int i = 1; i < N; i++) {
				if (h[i - 1] < h[i]) {
					if (down > 0) {
						cnt += up * down;
						up = 0; down = 0;
					}
					up++;
				} else 
					down++;
			}
			
			cnt += up * down;
			
			System.out.println("#" + t + " " + cnt);
		}
	}

}
