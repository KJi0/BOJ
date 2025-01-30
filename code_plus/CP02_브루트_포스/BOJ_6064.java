package code_plus.CP02_브루트_포스;

/*
 * BOJ 6064 : 카잉 달력
 * 너 무 어 려 워 요... 궁서체
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6064 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int lcm = M * N / gcd(M, N);
			
			int year = x;
			
			while (year <= lcm) {
				
				if (N == y) y = 0;
				
				if (year % N == y) {
					sb.append(year).append('\n');
					break;
				}
				year += M;
			}
			
			if (year > lcm) sb.append(-1).append('\n');
		}
		System.out.print(sb);
	}

	public static int gcd(int a, int b) {
		if (a % b == 0) 
			return b;
		
		return gcd(b, a % b);
	}
}
