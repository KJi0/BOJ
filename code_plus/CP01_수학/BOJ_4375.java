package code_plus.CP01_수학;

/*
 * BOJ 4375 : 1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4375 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s;
		
		while ((s = br.readLine()) != null) {
			int n = Integer.parseInt(s);
			int base = 1;
			int cnt = 1;
			
			while (base % n != 0) {
				base = (base * 10 + 1) % n;
				cnt++;
			}
			
			sb.append(cnt).append('\n');
		}
		
		System.out.print(sb);
	}
}