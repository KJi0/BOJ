package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1289 {
	/*
	 * SWEA 1289: 원재의 메모리 복구하기
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			char[] memory = br.readLine().toCharArray();
			int N = memory.length;
			
			char[] origin = new char[N];
			for (int i = 0; i < N; i++)	origin[i] = '0';
	
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (memory[i] == origin[i]) continue;
				
				for (int j = i; j < N; j++) {
					origin[j] = memory[i];
				}
				
				cnt++;
			}
			
			System.out.println("#" + t + " " + cnt);
		}
	}
}