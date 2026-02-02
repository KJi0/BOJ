package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3499 {
	/*
	 * SWEA 3499: 퍼펙트 셔플 
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] arr = new String[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) arr[i] = st.nextToken();
			
			int mid = (N + 1) / 2;
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			
			int i = 0; int j = mid;
			while (i < mid || j < N) {
				if (i < mid) sb.append(arr[i++]).append(" ");
				if (j < N) sb.append(arr[j++]).append(" ");
			}
			
			System.out.println(sb);
		}
	}

}
