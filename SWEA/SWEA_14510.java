package SWEA;

/*
 * SWEA 14510: 나무 높이
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_14510 {
	static int N;
	static int[] tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			tree = new int[N]; 
			
			int tallest = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				tallest = Math.max(tallest, tree[i]);
			}
			
			int even = 0; int odd = 0;
			for (int i = 0; i < N; i++) {
				if (tallest - tree[i] == 0) continue;
				int diff = tallest - tree[i];
				
				even += diff / 2;
				odd += diff % 2;
			}
			
			// 2가 1보다 많고 2개 이상 차이 = 차이 1개 이하로 만들기
			// 1이 2보다 많은 경우 = 2 * 1개수 - 1
			// 2가 1보다 많고 1개 차이 = 2 * 2개수
			// 1과 2가 같은 경우 = 1개수 + 2개수
			
			if (even - odd > 1) {
				while (Math.abs(even - odd) > 1) {
					even--;
					odd += 2;
				}
			}
			
			int day = 0;
			if (even >= odd) {
				if (even - odd == 1) day = 2 * even;
				if (even == odd) day = even + odd;
			} else
				day = 2 * odd - 1;
			
			System.out.println("#" + t + " " + day);
		}
	}

}
