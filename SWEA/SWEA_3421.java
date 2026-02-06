package SWEA;

/*
 * SWEA 3421: 수제 버거 장인
 * 비트마스킹 기법 기억해 두기!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3421 {
	static int N, M, total;
	static int[] mask;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			mask = new int[N];
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				
				mask[a] |= (1 << b);
				mask[b] |= (1 << a);
			}
			
			total = 0;
			dfs(0, 0);
			System.out.println("#" + t + " " + total);
		}
	}
	
	static void dfs(int idx, int state) {
		if (idx == N) {
			total++;
			return;
		}
		
		if ((state & mask[idx]) == 0) dfs(idx + 1, state | (1 << idx));
		
		dfs(idx + 1, state);
	}
}